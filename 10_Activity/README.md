# Activity #1 Homework

**Цели работы:** научиться работать с различными launch модами запуска Activity, познакомиться с Activity Task

### Задание #1

1. Cоздайте 4 класса Activity и назовите их **ActivityA**-**ActivityD**.
    - [x] В layout файл **ActivityA** добавьте кнопку с текстом “Open ActivityB”
    - [x] В layout файл **ActivityB** добавьте кнопку с текстом “Open ActivityC”
    - [x] В layout файл **ActivityC** добавьте кнопки с текстом “Open ActivityA”, “Open ActivityD”, “Close ActivityC”, “Close Stack”
2. Покрасьте бекграунды Activity: **ActivityA** в `#f44336`, **ActivityB** в `#4caf50,` **ActivityC** в `#2196f3`, **ActivityD** в `#ffeb3b`

    <aside>
    💡 Используйте атрибут `android:background`
    </aside>

3. Подготовьте пустые `onClickListener`’ы для обработки нажатия на кнопки

### Задание #2

- [x] По клику на кнопку “Open ActivityB” запустите **ActivityB** в отдельном стеке, при этом предусмотрите возможность открывать другие Activity в том же стеке где расположена **ActivityA**
<img src="readme_image/01.png" alt="Untitled" height="400"/>

- [x] По клику на кнопку “Open ActivityC” запустите **ActivityC** в том же стеке, в котором расположена **ActivityB**
<img src="readme_image/02.png" alt="Untitled" height="400"/>

- [x] По клику на кнопку “Open ActivityA” запустите **ActivityA**, таким образом, чтобы мы попали на существующий экземпляр  **ActivityA** и у него был вызван метод `onNewIntent`, независимо от того находится **ActivityA** наверху своего стека или нет
<img src="readme_image/03.png" alt="Untitled" height="400"/>

- [x] По клику на кнопку “Open ActivityD” запустите **ActivityD** в том же стеке, где расположены **ActivityB** и **ActivityC**, при этом завершите все предыдущие Activity, которые находятся в текущем стеке
<img src="readme_image/04.png" alt="Untitled" height="400"/>

- [x] По клику на кнопку “CloseActivityC”, завершите **ActivityC**, и перейдите на предыдущий экран в стеке
<img src="readme_image/05.png" alt="Untitled" height="400"/>

- [x] По клику на кнопку “Close Stack” завершите текущий стек, в котором находятся **ActivityB** и **ActivityC**, и перейдите на **ActivityA**
<img src="readme_image/06.png" alt="Untitled" height="400"/>