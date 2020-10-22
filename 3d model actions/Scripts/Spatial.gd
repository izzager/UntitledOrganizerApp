extends Spatial


onready var camera = get_node("CameraSpatial")
var strength =  0.15
var swipe_strength = 0.01
var swipe_start 
var swipe_end
var con = false
signal nextAnim()
signal prevAnim()

# Called when the node enters the scene tree for the first time.
func _ready():
	pass

func _process(_delta):
	var xDir = Input.get_action_strength("ui_right") - Input.get_action_strength("ui_left")
	var yDir = Input.get_action_strength("ui_down") - Input.get_action_strength("ui_up")
	camera.rotation += Vector3(yDir * strength, xDir * strength, 0)
	if Input.is_action_just_pressed("ui_nextAnim"): 
		#camera.rotation = Vector3(0, 0, 0)
		emit_signal("nextAnim")
		
	if Input.is_action_just_pressed("ui_prevAnim"): 
		#camera.rotation = Vector3(0, 0, 0)
		emit_signal("prevAnim")
		
	if Input.is_action_just_pressed("ui_click"):
		#Получение начальной точки свайпа
			swipe_start = get_viewport().get_mouse_position()
			print("swipe_start = ", swipe_start)
	
	if Input.is_action_pressed("ui_click"):
		#Получение конечной точки свайпа и в зависимости от неё изменяется положение камеры
		swipe_end = get_viewport().get_mouse_position()
		camera.rotation += Vector3((swipe_start.y - swipe_end.y) * swipe_strength, (swipe_start.x - swipe_end.x) * swipe_strength, 0)
		swipe_start = get_viewport().get_mouse_position()
		
	
