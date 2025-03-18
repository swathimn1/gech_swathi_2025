from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='employee_home'),  # Add this to handle /employee/
    path('home/', views.home, name='home'),
    path('edit/<int:id>/', views.edit_employee, name='edit'),
    path('delete/<int:id>/', views.delete_employee, name='delete'),
]
