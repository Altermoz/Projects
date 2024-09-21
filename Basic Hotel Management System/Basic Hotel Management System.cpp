#include<iostream>
#include<string>
#include<vector>
using namespace std;
class Room{
    public:
        int room_number;
        string room_type;
        bool is_booked;
        Room (int number, string type){
            room_number = number;
            room_type = type;
            is_booked = false;
        }
        void Book_Room(){
            if(is_booked){
                is_booked=true;
                cout<<"Room"<<room_number<<"has been booked.\n";
            }
            else{
                cout<<"Room"<<room_number<<"is already booked.\n";
            }
        }
        void Check_Out_Room(){
            if(is_booked){
                is_booked=false;
                cout<<"Room"<<room_number<<"is now available.\n";
            }
            else{
                cout<<"Room"<<room_number<<"is already available.\n";
            }
        }
};
class Hotel{
    public:
        vector<Room> rooms;
        Hotel(int number_of_rooms){
            for(int i=1;i<=number_of_rooms;i++){
                string type=(i% 2==0)?"Deluxe":"Standard";
                rooms.push_back(Room(i,type));
            }
        }
        void Show_Available_Rooms(){
            cout<<"Available Rooms:\n";
            for(vector<Room>::iterator it = rooms.begin(); it != rooms.end(); ++it){
                Room &room = *it;
                if(!room.is_booked){
                    cout<<"Room"<<room.room_number<<"("<<room.room_type<<")\n";
                }
            }
        }
        void Book_Room(int room_number){
            if(room_number>0 && room_number<=rooms.size()){
                rooms[room_number-1].Book_Room();
            }
            else{
                cout<<"Invalid room number.\n";
            }
        }
        void Check_Out_Room(int room_number){
            if(room_number>0 && room_number<=rooms.size()){
                rooms[room_number-1].Check_Out_Room();
            }
            else{
                cout<<"Invalid room number.\n";
            }
        }
};
int main(){
    int number_of_rooms=10;
    Hotel myHotel(number_of_rooms);
    int choice,room_number;
    do{
        cout<<"\nHotel Management System\n";
        cout<<"1. Show Available Rooms\n";
        cout<<"2. Book A Room\n";
        cout<<"3. Check From Room\n";
        cout<<"4. Exit\n";
        cout<<"Enter your choice :";cin>>choice;
        switch (choice){
            case 1:
                myHotel.Show_Available_Rooms();
                break;
            case 2:
                cout<<"Enter room number to book :";cin>>room_number;
                myHotel.Book_Room(room_number);
                break;
            case 3:
                cout<<"Enter room number to checkout :";cin>>room_number;
                myHotel.Check_Out_Room(room_number);
                break;
            case 4:
                cout<<"Exiting...\n";
                break;
            default:
                cout<<"Invalid choice. Please try again.\n";
                break;
        }
    }
    while(choice !=4);
    return 0;
}