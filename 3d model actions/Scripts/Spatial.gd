extends Spatial


onready var camera = get_node("CameraSpatial")
onready var cameraMove = camera.get_child(0)
onready var slider_cameraMove = get_node("Ui_camera/slider_cameraMove")
var rotateStrength = 0.15
var moveStrength = 0.5
var swipe_strength = 0.01
var swipe_start 
var swipe_end
var con = false
signal nextAnim()
signal prevAnim()

# Called when the node enters the scene tree for the first time.
func _ready():
	#get_node("Zoom/btn_closerZoom").connect("pressed", self, "closerZoom")
	#get_node("Zoom/btn_fartherZoom").connect("pressed", self, "fartherZoom")
	get_node("Ui_camera/btn_resetCamera").connect("pressed", self, "resetCamera")
	slider_cameraMove.connect("value_changed", self, "cameraZoom")
	slider_cameraMove.value = cameraMove.translation.z
	

func _process(_delta):
	var xDir = Input.get_action_strength("ui_right") - Input.get_action_strength("ui_left")
	var yDir = Input.get_action_strength("ui_down") - Input.get_action_strength("ui_up")
	camera.rotation += Vector3(yDir * rotateStrength, xDir * rotateStrength, 0)
	if Input.is_action_just_pressed("ui_nextAnim"): 
		emit_signal("nextAnim")
		
	if Input.is_action_just_pressed("ui_prevAnim"): 
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
		
func cameraZoom(value):
	cameraMove.translation = Vector3(0, 0, value)
	
func resetCamera():
	camera.rotation = Vector3(-.3, 0, 0)
	cameraMove.translation = Vector3(0, 0, 4)
	slider_cameraMove.value = 4
