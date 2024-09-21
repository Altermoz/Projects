#include <iostream>
#include <string>
#include <ctime>
using namespace std;

string generateNextGuess(const string& guess){
    string nextGuess = guess;
    int i = nextGuess.length() - 1;

    while (i >= 0 && nextGuess[i] == 'z'){
        nextGuess[i] = 'a';
        i--;
    }
    if (i >= 0){
        nextGuess[i]++;
    }

    return nextGuess;
}

int main(){
    string userWord;
    cout << "Enter a word to be cracked: ";
    getline(cin, userWord);

    string guess(userWord.length(), 'a');

    unsigned long long attempts = 0;

    clock_t start = clock();

    while (guess != userWord){
        cout << "Guess" << attempts + 1 << ": " << guess << endl;
        guess = generateNextGuess(guess);
        attempts++;
    }

    clock_t end = clock();
    double duration = double(end - start) / CLOCKS_PER_SEC;

    cout << "Word cracked! The word is: " << guess << endl;
    cout << "Number of attempts: " << attempts << endl;
    cout << "Time taken: " << duration << " seconds" << endl;

    return 0;
}
