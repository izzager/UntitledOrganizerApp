extends Node
onready var login = get_node("TextEdit")
onready var password = get_node("TextEdit2")

func _on_Button_pressed():	
	var logtxt = login.text
	var passtxt = password.text	
	if (logtxt == "admin") && (passtxt == "admin"):
	   get_tree().change_scene("res://Games.tscn")
	else:
		var lab = get_node("Label")
		lab.set_text("Неверный логин или пароль")


func _on_BtnRegistration_pressed():
	get_tree().change_scene("res://Registration.tscn")



func _on_BtnForgotPas_pressed():
	get_tree().change_scene("res://ForgotPassword.tscn")
