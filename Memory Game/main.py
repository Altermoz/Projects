import random
import os

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def create_board(size=4):
    cards = list('ABCDEFGHIJKLMNOPQRSTUVWXYZ')[:size*size//2] * 2
    random.shuffle(cards)
    board = []
    for i in range(size):
        board.append(cards[i*size:(i+1)*size])
    return board

def display_board(board, revealed):
    for i, row in enumerate(board):
        for j, card in enumerate(row):
            if revealed[i][j]:
                print(f" {card} ", end="")
            else:
                print(" X ", end="")
        print()

def check_win(revealed):
    return all(all(row) for row in revealed)
def play_memory_game():
    size = 4
    board = create_board(size)
    revealed = [[False] * size for _ in range(size)]
    turns = 0

    while not check_win(revealed):
        clear_screen()
        display_board(board, revealed)
        print("\nPick two cards to flip (format: row column).")
        row1, col1 = map(int, input("First card (row col): ").split())
        if revealed[row1][col1]:
            print("Card already revealed. Try again.")
            input("Press Enter to continue...")
            continue
        row2, col2 = map(int, input("Second card (row col): ").split())
        if revealed[row2][col2] or (row1 == row2 and col1 == col2):
            print("Invalid Selection. Try again.")
            input("Press Enter to continue...")
            continue
        revealed[row1][col1] = True
        revealed[row2][col2] = True

        clear_screen()
        display_board(board, revealed)

        if board[row1][col1] != board[row2][col2]:
            print("No match! Try again.")
            revealed[row1][col1] = False
            revealed[row2][col2] = False
        else:
            print("Match found!")
        
        turns += 1
        input("Press Enter to continue...")
    
    clear_screen()
    display_board(board, revealed)
    print(f"\nCongratulations! You found all pairs in {turns} turns.")

play_memory_game()