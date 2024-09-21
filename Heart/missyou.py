import turtle

t = turtle.Turtle()
turtle.title("For girlfriend")

screen=turtle.Screen()
screen.bgcolor("black")

t.color("red")
t.fillcolor("pink")
t.begin_fill()

t.left(140)
t.forward(180)
t.circle(-90,200)
t.setheading(60)
t.circle(-90,200)
t.forward(180)

t.end_fill()

t.up()
t.setpos(-65, 150)
t.down()
t.color('black')
t.write("i miss you baby", font=("Verdana", 15, "bold"))

t.ht()

turtle.mainloop()