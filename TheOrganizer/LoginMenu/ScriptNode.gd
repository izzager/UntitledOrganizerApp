extends Node
onready var login = get_node("Login")
onready var password = get_node("Password")

func _on_Button_pressed():	
	var logtxt = login.text
	var passtxt = password.text	
	if (logtxt == "admin") && (passtxt == "admin"):
	   get_tree().change_scene("res://Games & Organizers/Games.tscn")
	else:
		var lab = get_node("Label")
		lab.set_text("Неверный логин или пароль")


func _on_BtnRegistration_pressed():
	get_tree().change_scene("res://Registration/Registration.tscn")



func _on_BtnForgotPas_pressed():
	get_tree().change_scene("res://ForgotPassword/ForgotPassword.tscn")
