from django.db import models

class Employee(models.Model):
    name = models.CharField(max_length=100, blank=False)
    email = models.EmailField(unique=True, blank=False)
    designation = models.CharField(max_length=100, blank=False)  # Add Designation
    salary = models.DecimalField(max_digits=10, decimal_places=2, blank=False)

    def _str_(self):
        return self.name 