from django.urls import path
from . import views
urlpatterns = [
   path("home/",views.home,name="home"),
   path("about/",views.about),
   path("contact/",views.contact)
   
    
]