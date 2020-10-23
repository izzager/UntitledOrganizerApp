extends Node
onready var Email = get_node("EnterEmail")
onready var Error = get_node("Error")


func _on_Btn_Send_Message_pressed():
	var email = Email.text
	if (email != null):	
		get_tree().change_scene("res://ForgotPassword/FromForgotPasswordToLogin.tscn")
	else:
		Error.Text = "Ошибка при вводе данных"


func _on_Btn_Back_To_Login_pressed():
	get_tree().change_scene("res://LoginMenu/LoginMenu.tscn")
