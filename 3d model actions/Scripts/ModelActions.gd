extends Spatial

export(float, 1, 10, 0.1) var animSpeed
var anim = 0
var pause = false
var animating = false
var curAnim
var back = false
onready var AnimPlayer = get_child(0).get_node("AnimationPlayer")
onready var animLen = AnimPlayer.get_animation_list().size()


func _ready():
	#Подключение всех функций с элементоми
	connectAll()
	
	
func connectAll():
	#Конец аниммации вызывает animEnd
	AnimPlayer.connect("animation_finished", self, "animEnd")
	#Получение основного узла
	var allNodes = get_parent()
	#Требование след анимации вызывает nextAnim
	allNodes.connect("nextAnim", self, "nextAnim")
	allNodes.get_node("UI/btn_nextAnim").connect("pressed", self, "nextAnim")
	#Требование пред анимации вызывает prevAnim
	allNodes.connect("prevAnim", self, "prevAnim")
	allNodes.get_node("UI/btn_prevAnim").connect("pressed", self, "prevAnim")
	#Получение слайдера для скорости и связка его изменения с изменением скорости анимации
	var slider_speedAnim = allNodes.get_node("UI/slider_speedAnim")
	slider_speedAnim.connect("value_changed", self, "speedChange")
	#Установка стартового значения в стартовую позицию слайдера
	slider_speedAnim.value = animSpeed
	
	
func speedChange(value):
	#изменение слайдера изменяет скорость анимации
	animSpeed = value
	if not back:
		#Если последняя анимация не является шагом назад то изменяем скорость в плеере
		AnimPlayer.playback_speed = animSpeed


func animEnd(_animName):
	#при конце анимации отпускаем паузу
	pause = false


func nextAnim():
	#если не пвуза и может быть совершена следующая анимация
	if not pause and anim < animLen:
		#увеличиваем шаг анимации
		anim += 1
		#анимация не идёт назад
		back = false
		#устанавливаем скорость анимации
		AnimPlayer.playback_speed = animSpeed
		#включаем нужную анимацию 
		AnimPlayer.play("Action" + str(anim))
		#делаем паущу
		pause = true

func prevAnim():
	#если не пвуза и может быть совершен шаг назад
	if not pause and anim > 0:
		#последний шаг идёт назад
		back = true
		#воспроизводим анимацию заново с 0
		AnimPlayer.play("Action" + str(anim))
		#анимация перестаёт воспроизводиться
		AnimPlayer.playback_speed = 0
		#сдвигаем на предылущий шаг
		anim -= 1
