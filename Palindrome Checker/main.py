import tkinter as tk
from tkinter import messagebox
def check_palindrome():
    word = entry.get().lower()
    if word == word[::-1]:
        messagebox.showinfo("Result", f"{word} is a palindrome")
    else:
        messagebox.showinfo("Result", f"{word} is not a palindrome")

root = tk.Tk()
root.title("Palindrome Checker")

label = tk.Label(root, text="Enter a number:")
label.pack(pady=10)

entry = tk.Entry(root)
entry.pack(pady=5)

check_button = tk.Button(root, text="Check", command=check_palindrome)
check_button.pack(pady=10)

root.mainloop()