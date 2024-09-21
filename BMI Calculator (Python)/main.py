import customtkinter as ctk # type:ignore

class BMICalculator(ctk.CTk):
    def __init__(self):
        super().__init__()
        self.title("BMI Calculator")

        self.weight_label = ctk.CTkLabel(self, text="Weight (kg):")
        self.weight_label.grid(row=0, column=0, padx=10, pady=5)
        self.weight_entry = ctk.CTkEntry(self)
        self.weight_entry.grid(row=0, column=1, padx=10, pady=5)

        self.height_label = ctk.CTkLabel(self, text="Height (cm):")
        self.height_label.grid(row=1, column=0, padx=10, pady=5)
        self.height_entry = ctk.CTkEntry(self)
        self.height_entry.grid(row=1, column=1, padx=10, pady=5)

        self.calculate_button = ctk.CTkButton(self, text="Calculate BMI", command=self.calculate_bmi)
        self.calculate_button.grid(row=2, column=0, columnspan=2, padx=10, pady=5)

        self.result_label = ctk.CTkLabel(self, text="")
        self.result_label.grid(row=3, column=0, columnspan=2, padx=10, pady=5)
    
    def calculate_bmi(self):
        try:
            weight = float(self.weight_entry.get())
            height = float(self.height_entry.get()) / 100
            bmi = weight / (height ** 2)
            self.result_label.configure(text="Your BMI is: {:.2f}".format(bmi))
        except ValueError:
            self.result_label.configure(text="Invalid input. Please enter valid numbers.")

if __name__ == "__main__":
    app = BMICalculator()
    app.mainloop()