extends Node
onready var response

#в общем это нужно привесить на само открытие сцены или как там я хз как называется
#то есть сцена открывается и сразу запрос делается
func _ready():
	# Create an HTTP request node and connect its completion signal.
	var http_request = HTTPRequest.new()
	add_child(http_request)
	http_request.connect("request_completed", self, "_http_request_completed")

	# POST request
	var error = http_request.request('http://localhost:8080/games', [], true, HTTPClient.METHOD_POST)
	if error != OK:
		push_error("An error occurred in the HTTP request.")

#ну и когда ответ на запрос приходит обратно
func _on_HTTPRequest_request_completed(result, response_code, headers, body):
	if response_code == 200:
		#здесь результат просто конвертируется в привычный со времен php джисон
		#то есть массивчик [] (можно обращаться по номеру в массиве), 
		#а внутри него элементы в виде {ключ1: значение1, ...}
		response = parse_json(body.get_string_from_utf8())

	else:
		print('unsuc')
	pass
