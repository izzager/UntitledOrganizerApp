extends WorldEnvironment

onready var camera = get_node("CameraSpatial")
onready var cameraMove = get_node("CameraSpatial/Camera")
onready var btnZoomIn = get_node("Ui_camera/VBox_Zoom/btn_ZoomIn")
onready var btnZoomOut = get_node("Ui_camera/VBox_Zoom/btn_ZoomOut")
var cameraStartRotation = Vector3(-.3, 0, 0)
var cameraStartTranslation = Vector3(0, 0, 4)
var rotateStrength = 0.15
var translationStrength = Vector3(0, 0, 0.05)
var swipe_strength = 0.01
var swipe_start 
var swipe_end
var zoomIn = false
var zoomOut = false
signal nextAnim()
signal prevAnim()
signal loadEnd()

# Called when the node enters the scene tree for the first time.
func _ready():
	connectAll()
	
func connectAll():
	get_node("Ui_camera/VBox_TopRight/btn_CameraReset").connect("pressed", self, "resetCamera")
	btnZoomIn.connect("button_down", self, "ZoomInOn")
	btnZoomOut.connect("button_down", self, "ZoomOutOn")
	btnZoomIn.connect("button_up", self, "ZoomInOff")
	btnZoomOut.connect("button_up", self, "ZoomOutOff")
	#Добавляем загружаемую модель
	var box = preload("res://box.tscn").instance()
	box.translation = Vector3(0,0,0)
	get_node("Model").add_child(box)
	#подаём об этом сигнал
	emit_signal("loadEnd")

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
		
	if zoomIn: ZoomIn()
	if zoomOut: ZoomOut()

		
func ZoomInOn():
	zoomIn = true
func ZoomInOff():
	zoomIn = false
func ZoomIn():
	cameraMove.translation -= translationStrength
	
func ZoomOutOn():
	zoomOut = true
func ZoomOutOff():
	zoomOut = false
func ZoomOut():
	cameraMove.translation += translationStrength
	
func resetCamera():
	camera.rotation = cameraStartRotation
	cameraMove.translation = cameraStartTranslation
