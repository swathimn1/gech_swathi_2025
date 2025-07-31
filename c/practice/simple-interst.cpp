#include<iostream>
using namespace std;

class SimpleInterest {
private:
    int principal, time;
    int RateinInteger;
    float RateinFloat;
public:
    float simpleinterest;

    // Constructor for integer rate
    SimpleInterest(int p, int t, int r) {
        principal = p;
        time = t;
        RateinInteger = r;
        simpleinterest = (principal * time * RateinInteger) / 100.0;
        cout << "\n[Using Integer Rate]\n";
        cout << "Principal: " << principal << ", Time: " << time << ", Rate: " << RateinInteger << endl;
        cout << "Simple Interest: " << simpleinterest << endl;
        cout << "Total Amount: " << simpleinterest + principal << endl;
    }

    // Constructor for float rate
    SimpleInterest(int p, int t, float r) {
        principal = p;
        time = t;
        RateinFloat = r;
        simpleinterest = (principal * time * RateinFloat) / 100.0;
        cout << "\n[Using Float Rate]\n";
        cout << "Principal: " << principal << ", Time: " << time << ", Rate: " << RateinFloat << endl;
        cout << "Simple Interest: " << simpleinterest << endl;
        cout << "Total Amount: " << simpleinterest + principal << endl;
    }

    // Default constructor
    SimpleInterest() {
        principal = 0;
        time = 0;
        RateinInteger = 0;
        RateinFloat = 0;
        simpleinterest = 0;
    }
};

int main() {
    int p, t, r;
    float R;

    cout << "Enter principal amount: ";
    cin >> p;
    cout << "Enter time (years): ";
    cin >> t;
    cout << "Enter rate (integer): ";
    cin >> r;
    cout << "Enter rate (float): ";
    cin >> R;

    SimpleInterest s1(p, t, r);
    SimpleInterest s2(p, t, R);

    return 0;
}
