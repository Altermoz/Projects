import tkinter as tk
from tkinter import messagebox

class ShoppingListApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Shopping List")

        self.frame = tk.Frame(root)
        self.frame.pack(pady=10)

        self.listbox = tk.Listbox(self.frame, width=50, height=10)
        self.listbox.pack(side=tk.LEFT, padx=(0, 10))

        self.scrollbar = tk.Scrollbar(self.frame, orient=tk.VERTICAL)
        self.scrollbar.config(command=self.listbox.yview)
        self.scrollbar.pack(side=tk.LEFT, fill=tk.Y)

        self.listbox.config(yscrollcommand=self.scrollbar.set)

        self.entry = tk.Entry(root, width=50)
        self.entry.pack(pady=10)

        self.add_button = tk.Button(root, text="Add Item", command=self.add_item)
        self.add_button.pack(side=tk.LEFT, padx=(10, 5))

        self.delete_button = tk.Button(root, text="Delete Item", command=self.delete_item)
        self.delete_button.pack(side=tk.LEFT, padx=(5, 10))

        self.clear_button = tk.Button(root, "Clear List", command=self.clear_list)
        self.clear_button.pack(side=tk.LEFT, padx=(5, 10))

    def add_item(self):
        item = self.entry.get()
        if item:
            self.listbox.insert(tk.END, item)
            self.entry.delete(0, tk.END)
        else:
            messagebox.showwarning("Warning", "Please enter an item")
    
    def delete_item(self):
        try:
            selected_index = self.listbox.curselection()[0]
            self.listbox.delete(selected_index)
        except IndexError:
            messagebox.showwarning("Warning", "Please select an item to delete")

    def clear_list(self):
        self.listbox.delete(0, tk.END)

if __name__ == "__main__":
    root = tk.Tk()
    app = ShoppingListApp(root)
    root.mainloop()