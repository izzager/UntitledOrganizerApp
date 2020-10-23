extends Node
onready var scrollcontainer = get_node("ScrollContainer")
var swipe_start
var swipe_end

func _ready():
	# Create an HTTP request node and connect its completion signal
	var http_request = HTTPRequest.new()
	add_child(http_request)
	http_request.connect("request_completed", self, "_http_request_completed")

	# Perform the HTTP request. The URL below returns a PNG image as of writing.
	var http_error = http_request.request("https://via.placeholder.com/500")
	if http_error != OK:
		print("An error occurred in the HTTP request.")

# Called when the HTTP request is completed.
func _http_request_completed(result, response_code, headers, body):
	var image = Image.new()
	var image_error = image.load_png_from_buffer(body)
	if image_error != OK:
		print("An error occurred while trying to display the image.")

	var texture = ImageTexture.new()
	texture.create_from_image(image)
	
	var times = 10
	while times >= 0:
		
		
		times = times - 1
	
# Assign to the child TextureRect node

func _process(_delta):
	if Input.is_action_just_pressed("ui_click"):
		#Получение начальной точки свайпа
		swipe_start = get_viewport().get_mouse_position()
	if Input.is_action_pressed("ui_click"):
		#Получение конечной точки свайпа и в зависимости от неё изменяется положение камеры
		swipe_end = get_viewport().get_mouse_position()
		var scrollcontainerScrollBar = scrollcontainer.get_v_scrollbar()
		scrollcontainerScrollBar.value += swipe_start.y - swipe_end.y
		swipe_start = get_viewport().get_mouse_position()
