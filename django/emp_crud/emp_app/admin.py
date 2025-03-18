from django.contrib import admin
from . import models
# Register your models here.
@admin.register(models.Employee)
class employeeAdmin(admin.ModelAdmin):
    list_display=["id","name","email","designation","salary"]
