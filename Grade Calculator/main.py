import customtkinter as ctk

class GPACalculator(ctk.CTk):
    def __init__(self):
        super().__init__()

        self.title("GPA Calculator")
        self.geometry("400x300")

        self.grade_label = ctk.CTkLabel(self, text="Grade:")
        self.grade_label.grid(row=0, column=0, padx=10, pady=10)
        self.grade_entry = ctk.CTkEntry(self)
        self.grade_entry.grid(row=0, column=1, padx=10, pady=10)

        self.credit_label = ctk.CTkLabel(self, text="Credit Hours:")
        self.credit_label.grid(row=1, column=0, padx=10, pady=10)
        self.credit_entry = ctk.CTkEntry(self)
        self.credit_entry.grid(row=1, column=1, padx=10, pady=10)

        self.add_button = ctk.CTkButton(self, text="Add Course", command=self.add_course)
        self.add_button.grid(row=2, column=0, columnspan=2, padx=10, pady=10)

        self.course_list = ctk.CTkTextbox(self, height=10)
        self.course_list.grid(row=3, column=0, columnspan=2, padx=10, pady=10)

        self.calculate_button = ctk.CTkButton(self, text="Calculate GPA", command=self.calculate_gpa)
        self.calculate_button.grid(row=1, column=0, columnspan=2, padx=10, pady=10)

        self.result_label = ctk.CTkLabel(self, text="")
        self.result_label.grid(row=5, column=0, columnspan=2, padx=10, pady=10)

        self.courses = []

    def add_course(self):
        try:
            grade = float(self.grade_entry.get())
            credits = float(self.credit_entry.get())
            self.courses.append((grade, credits))
            self.course_list.insert(ctk.END, f"Grade: {grade}, Credits: {credits}\n")
            self.grade_entry.delete(0, ctk.END)
            self.credit_entry.delete(0, ctk.END)
        except ValueError:
            self.result_label.configure(text="Please enter valid numbers for grade and credits.")
    
    def calculate_gpa(self):
        total_points = 0
        total_credits = 0
        for grade, credits in self.courses:
            total_points += grade * credits
            total_credits += credits
        if total_credits > 0:
            gpa = total_points / total_credits
            self.result_label.configure(text=f"Your GPA is: {gpa:.2f}")
        else:
            self.result_label.configure(text="No courses added yet.")

if __name__ == "__main__":
    app = GPACalculator()
    app.mainloop()