from django import forms
from . import models  

class StudentForm(forms.ModelForm):
    
    class Meta:
        model = models.Student
        fields = ["name","email","password"]
        widgets={
            "name":forms.TextInput(
            attrs={"class":"form-control","placeholder":"enter your name"}),
            "email": forms.EmailInput(
            attrs={"class":"form-control","placeholder":"enter your email"}),
            "password" : forms.PasswordInput(
                attrs={"class":"form-control","placeholder":"enter your password"}),
         }
