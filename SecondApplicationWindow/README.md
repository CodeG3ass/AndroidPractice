# CreatingSecondApplicationWindow
## Создание второго окна приложения

![image](https://user-images.githubusercontent.com/92590831/142440877-6380fcb5-e897-421b-8375-836c997e295a.png)

![image](https://user-images.githubusercontent.com/92590831/142440911-16105aca-8e90-46b9-8e0e-d02bcc6f0697.png)

![image](https://user-images.githubusercontent.com/92590831/142441851-9c0143e5-8fce-48ed-a09f-0187defd3e5e.png)

## Контрольные вопросы
- Зачем делить приложение на несколько окно? Почему нельзя использовать разные расположения?
Чтобы компоненты, неопределенные в различные промежутки времени, использовали несколько окон, что является значительно проще для реализации.
- Что такое интент и зачем он нужен?


- Как вызвать определенное окно своего приложение? А другого?
Намерение (Intent) - это механизм для описания одной операции - выбрать фотографию, отправить письмо, сделать звонок, запустить браузер и перейти по указанному адресу. В Android-приложениях многие операции работают через намерения.

- Что такое таск? Почему при перемещении между окнами работает кнопка “Назад”?

![image](https://user-images.githubusercontent.com/92590831/142444691-29f77f52-5054-48e0-b60f-677491d4a0e7.png)

Task – группа из нескольких Activity, с помощью которых пользователь выполняет определенную операцию. Обычно стартовая позиция для создания Task – это экран Домой (Home).
Находясь в Home вы вызываете какое-либо приложение из списка приложений или через ярлык. Создается Task. И Activity приложения (которое отмечено как MAIN в манифест-файле) помещается в этот Task как корневое. Task выходит на передний фон. Если же при вызове приложения, система обнаружила, что в фоне уже существует/
Task, соответствующий этому приложению, то она выведет его на передний план и создавать ничего не будет.


## Дополнительные задания
- Создайте приложение, состоящее из четырех активностей и реализуйте переходы между ними. 

![image](https://user-images.githubusercontent.com/92590831/142442519-26c8a6f2-9aae-462f-a339-d3c45359d055.png)

- Реализуйте переходы между активностями используя меню приложения. Меню должно быть описано в XML файле и быть общим для всех четырех активностей. 

![image](https://user-images.githubusercontent.com/92590831/142446062-c4fc8182-a536-483c-ab0e-d881aac931b7.png)

![image](https://user-images.githubusercontent.com/92590831/142446131-a15215e6-3395-442a-bca5-87a65e3267e4.png)

![image](https://user-images.githubusercontent.com/92590831/142446343-0e381012-5a9b-477c-a8f4-c848e5233bb2.png)

![image](https://user-images.githubusercontent.com/92590831/142446372-187cc947-e604-456c-8c00-5a742c959672.png)

- (*) Реализуйте передачу данных между активностями. В первом окне создайте текстовое поле для ввода имени и кнопку. При тапе на кнопку должно открываться второе окно, в котором отображается имя, введенное пользователем.

![image](https://user-images.githubusercontent.com/92590831/142444326-25ff636a-92c5-47cd-83f0-c4467b4264a0.png)

![image](https://user-images.githubusercontent.com/92590831/142444413-2b5d0d28-24ef-4742-87f6-2a8dadd2b597.png)

![image](https://user-images.githubusercontent.com/92590831/142444428-08b728d7-9aa3-41be-a287-cd5487274b5b.png)

