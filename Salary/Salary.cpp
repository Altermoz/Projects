#include <iostream>
using namespace std;

int main(){
    float total_time, extra_time, bonus_rate, bonus_salary, bonus_salary1, bonus_rate1, extra_rate1, extra_time1, lose_time, lose_rate, lose_salary, total_salary;
    
    cout << "Enter total time: ";
    cin >> total_time;

    if (total_time > 0){
        if (total_time >= 100){
            if (total_time == 100){
                cout << "Total Salary = $100" << endl;
            }

            else if (total_time <= 120){
                extra_time = total_time - 100;
                bonus_rate = 1.5;
                bonus_salary = bonus_rate * extra_time;
                total_salary = 100 + bonus_salary;
                cout << "Extra Time: " << extra_time << "h" << endl;
                cout << "Bonus Rate: " << bonus_rate << endl;
                cout << "Bonus Salary: $" << bonus_salary << endl;
                cout << "\n....................................." << endl;
                cout << "Total Salary: $" << total_salary << endl;
            }

            else if (total_time > 120){
                extra_time = total_time - 100;
                bonus_rate = 1.5;
                bonus_salary = 20 * bonus_rate;
                extra_time1 = extra_time - 20;
                bonus_rate1 = 1.75;
                bonus_salary1 = extra_time1 * bonus_rate1;
                total_salary = 100 + bonus_salary + bonus_salary1;
                cout << "Extra Time: " << extra_time << "h" << endl;
                cout << "Bonus Rate: $" << bonus_salary << endl;
                cout << "\n............................" << endl;
                cout << "Extra Time 1: " << extra_time1 << "h" << endl;
                cout << "Bonus Rate 1: $" << bonus_rate1 << endl;
                cout << "Bonus Salary 1: $" << bonus_salary1 << endl;
                cout << "\n.............................." << endl;
                cout << "Total Salary: $" << total_salary << endl;
            }

            else{
                lose_time = 100 - total_time;
                lose_rate = 0.5;
                lose_salary = lose_rate * lose_time;
                total_salary = 100 - lose_salary;
                cout << "Lose Time: " << lose_time << endl;
                cout << "Lose Rate: $" << lose_rate << endl;
                cout << "Lose Salary: $" << lose_salary << endl;
                cout << "\n..............................." << endl;
                cout << "Total Salary: $" << total_salary;
            }
        }
        
        else{
            cout << "Don't get salary for this month";
        }
    }
}