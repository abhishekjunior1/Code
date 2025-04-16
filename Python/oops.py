class student:
    def __init__(self,name):
        self.naam=name
        print("I am constructor")
    
    def printname(self):
        print("Student name is ", self.naam)
    
    def __del__(self):
        print("object destoyed")


class teacher(student):
    def __init__(self,name):
        super().__init__(name)
        self.printname()

    


obj1=teacher("Abhishek");
