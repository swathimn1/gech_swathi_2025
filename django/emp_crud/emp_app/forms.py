from django import forms
from .models import Employee

class EmployeeForm(forms.ModelForm):
    class Meta:
        model = Employee
        fields = ["name", "email", "designation", "salary"]
        widgets = {
            "name": forms.TextInput(attrs={"class": "form-control", "placeholder": "Enter Name"}),
            "email": forms.EmailInput(attrs={"class": "form-control", "placeholder": "Enter Email"}),
            "designation": forms.TextInput(attrs={"class": "form-control", "placeholder": "Enter Designation"}),
            "salary": forms.NumberInput(attrs={"class": "form-control", "placeholder": "Enter Salary"}),
}