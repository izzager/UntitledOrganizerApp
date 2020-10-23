extends Node
onready var login = get_node("LoginTxt")
onready var password = get_node("PasswordTxt")
onready var email = get_node("EmailTxt")
onready var error = get_node("Error")


func _on_BtnSendData_pressed():
	var logtxt = login.text
	var passtxt = password.text
	var emailtxt = email.text
	if (logtxt != null) && (passtxt != null) && (emailtxt != null):
		get_tree().change_scene("res://AfterRegistration.tscn")
	else:
		error.text = "Пустые поля"


func _on_BtnBack_pressed():
	get_tree().change_scene("res://LoginMenu.tscn")
