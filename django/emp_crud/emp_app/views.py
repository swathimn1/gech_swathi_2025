from django.shortcuts import render, redirect
from . import models
from . import views
from . import forms

# Create your views here.
def home(request):
    employees = models.Employee.objects.all()  # Ensure this is always defined
    
    if request.method == "POST":
        emp_form = forms.EmployeeForm(request.POST)
        if emp_form.is_valid():
            emp_form.save()
            employee_form = forms.EmployeeForm()  # Reset form after submission
        else:
            employee_form = emp_form  # Preserve form data with errors
    else:
        employee_form = forms.EmployeeForm()

    context = {
        "employees": employees,  # Always defined
        "employee_form": employee_form
    }

    return render(request, "home.html", context)


def edit_employee(request,id):
    employee=models.Employee.objects.get(id=id)   
    # select * from students where id=value
    if request.method=="POST":
        employee_form=forms.EmployeeForm(request.POST,instance=employee)
        if employee_form.is_valid():
            employee_form.save()
            return  redirect("home")
    else:
             employee_form=forms.EmployeeForm(instance=employee)
    context={
        "employee_form":employee_form
    }
    return render(request,"edit.html",context)
def delete_employee(request,id):
    employee=models.Employee.objects.get(id=id)   
    # select * from students where id=value
    
    if employee:
       employee.delete()
       return redirect("home")
    

   