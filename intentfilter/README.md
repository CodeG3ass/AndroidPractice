# Контрольные вопросы
## 1.	Какие существуют соглашения в порядке наименования действий?
Некоторые стандартные действия определены в классе Intent как константы ACTION_string, где string — название действия. Указывать такие действие нужно так: android.Intent.ACTION_string. Например, sndroid.Intent.ACTION_VIEW. Для действий, которые определяет разработчик, лучше всего использовать имя пакета приложения в качестве префикса для обеспечения уникальности. Например, com.example.project.CUSTOM_ACTION, где CUSTOM_ACTION — имя действия.
## 2.	Как передать информацию в активность используя неявный вызов?
Предать информацию в активность используя неявный вызов можно, указав ее вторым аргументом. Например, чтобы создать неявный интент с действием открытия ссылки в браузере, нужно указать адрес (объект Uri) вторым аргументом: 
Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
## 3.	Какие еще параметры можно задавать при создании неявного интента?
Можно указать пары ключ-значения для дополнительной информации так же, как это делается при вызове явного интента с помощью ряда методов Intent.put...(). Например, чтобы сохранить фотографию, сделанную пользователем из нашего приложения, в файл, нужно указать ключ MediaStore.EXTRA_OUTPUT и Uri, сооответсвующее файлу:
Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
## 4.	Зачем нужна категория в интент-фильтрах? Какие существуют категории?
Категории нужны, чтобы указать, при каких обстоятельствах действие должно обслуживаться. Можно задать собственные категории или же брать стандартные значения, предоставляемые системой:
•	ALTERNATIVE — действие должно быть доступно в качестве альтернативного тому, которое выполняется по умолчанию для элемента этого типа данных.
•	BROWSABLE — говорит о том, что действие доступно из браузера.
•	DEFAULT — категория, позволяющая сделать компонент обработчиком по умолчанию для действия, выполняемого с указанным типом.
•	GADGET — наличие этой категории указывает на то, что данная активность может запускаться внутри другой активности.
•	LAUNCHER — используя эту категорию, мы помещаем Activity в окно для запуска приложений.
•	и др.
## 5.	Зачем нужен элемент  <requestFocus>?
Элемент <requestFocus> позволяет установить фокус на нужном компоненте. Предположим, что у нас имеется три текстовых поля, и нужно, чтобы фокус был на втором поле. В этом случае достаточно добавить тег <requestFocus> внутри второго элемента EditText.
## 6.	Зачем нужны аргументы requestCode и resultCode в обратном интенте?
requestCode - это неотрицательное целое число, которое запоминается (обычно записывается в поле класса активности, вызывающей другое действие, как константа) и передается в функцию StartActivityForResult() вторым аргументом. Это число позволяет при завершении одной из активности в методе onActivityResult() различить по этому числу, какая именно Activity была завершена. А resultCode позволяет определить успешно


```XAML
<application
    android:allowBackup="true"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:roundIcon="@mipmap/ic_launcher_round"
    android:supportsRtl="true"
    android:theme="@style/Theme.IntentFilter">

    <activity
        android:name=".showdate"
        android:label="Time basic"
        android:exported="true">
        <intent-filter>
            <action android:name="android.example.intent.showdate" />

            <category android:name="android.intent.category.DEFAULT" />
        </intent-filter>
    </activity>

    <activity android:name=".showtime" android:label="Time basic"
        android:exported="true">
        <intent-filter>
            <action android:name="android.example.intent.showtime"  />
            <category android:name="android.intent.category.DEFAULT" />
        </intent-filter>
    </activity>


    <activity
        android:name=".MainActivity"
        android:exported="true">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>

    <activity android:name=".info" android:label="Info"
        android:exported="true">
        <intent-filter>
            <action android:name="android.example.intent.showtime"  />
            <action android:name="android.example.intent.showdate"  />

            <category android:name="android.intent.category.DEFAULT" />
        </intent-filter>
    </activity>


</application>

<Button
    android:id="@+id/btnTime"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_x="213dp"
    android:layout_y="107dp"
    android:text="Show time"></Button>

<Button
    android:id="@+id/btnDate"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_x="55dp"
    android:layout_y="108dp"
    android:text="Show date"></Button>

<TextView
    android:id="@+id/textView2"
    android:layout_width="113dp"
    android:layout_height="wrap_content"
    android:layout_x="15dp"
    android:layout_y="19dp"
    android:text="Last Name"></TextView>

<EditText
    android:id="@+id/etLName"
    android:layout_width="231dp"
    android:layout_height="25dp"
    android:layout_marginLeft="5dp"
    android:layout_x="68dp"
    android:layout_y="58dp"></EditText>
```
```Java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button btnTime = (Button) findViewById(R.id.btnTime);
    Button btnDate = (Button) findViewById(R.id.btnDate);

    btnTime.setOnClickListener(this);
    btnDate.setOnClickListener(this);
}
public void onClick(View v) {
    Intent intent;

    switch(v.getId()) {
        case R.id.btnTime:
            intent = new Intent("android.example.intent.showtime");
            startActivity(intent);
            break;
        case R.id.btnDate:
            intent = new Intent("android.example.intent.showdate");
            startActivity(intent);
            break;
    }

}
```
  
![image](https://user-images.githubusercontent.com/92590831/146295560-66360367-3744-44fd-996b-4146750ab0c2.png)

![image](https://user-images.githubusercontent.com/92590831/146295569-4ff2a41c-fe9b-4111-9529-b5b3213b5f2a.png)


![image](https://user-images.githubusercontent.com/92590831/146295575-1b4ec0c3-ce2f-4883-824e-d8a3a789162b.png)

![image](https://user-images.githubusercontent.com/92590831/146295587-a85493c8-2199-4648-9337-291405f9a925.png)

![image](https://user-images.githubusercontent.com/92590831/146295597-ebb95069-2e9c-44f9-8733-9614729ca275.png)

![image](https://user-images.githubusercontent.com/92590831/146295603-24868913-63bd-49bb-994f-7b44ab3fa01f.png)

![image](https://user-images.githubusercontent.com/92590831/146295611-f1bf263c-ba9d-4d29-98d6-b67c91cf6f26.png)

![image](https://user-images.githubusercontent.com/92590831/146295619-6f65685a-c804-4e31-8117-459fe7a46b23.png)

![image](https://user-images.githubusercontent.com/92590831/146295623-ab8242da-f419-40ef-a51a-148feadbf5d4.png)

![image](https://user-images.githubusercontent.com/92590831/146295635-d9f55443-02da-40cb-9536-d390c55e3cf7.png)

![image](https://user-images.githubusercontent.com/92590831/146295640-998c1c78-0dac-4fbe-8e16-d8f083913759.png)

![image](https://user-images.githubusercontent.com/92590831/146295644-0ffac05f-dc85-4dc9-99be-b20bb56aaecc.png)

![image](https://user-images.githubusercontent.com/92590831/146295653-b5628651-b217-4e8b-beda-601e8a84cc76.png)

![image](https://user-images.githubusercontent.com/92590831/146295658-9f05d084-5486-4c96-8a9d-bce11835e59a.png)

![image](https://user-images.githubusercontent.com/92590831/146295664-a26ed8d2-cd78-4db0-bbbb-51f81fc06070.png)

![image](https://user-images.githubusercontent.com/92590831/146295669-6e8dfffd-3122-4308-9431-6682ec4e2fa7.png)

![image](https://user-images.githubusercontent.com/92590831/146295674-aa303c08-986f-453a-a8be-6a90181c3114.png)

![image](https://user-images.githubusercontent.com/92590831/146295676-ee8270f5-8234-48a6-b2c7-18048ff93475.png)

![image](https://user-images.githubusercontent.com/92590831/146295680-b3469ed0-3d35-474d-ae10-bc17cfa237f8.png)

![image](https://user-images.githubusercontent.com/92590831/146295685-ea8deb4c-e303-4ebb-93f0-6f752321753a.png)

![image](https://user-images.githubusercontent.com/92590831/146295690-4f73b2c4-5bf4-4b0a-ab53-798d50432d50.png)

![image](https://user-images.githubusercontent.com/92590831/146295725-3aa4fdfe-d5a9-4c59-ad72-65e09f723c5e.png)

![image](https://user-images.githubusercontent.com/92590831/146295694-9903713d-dd89-4f64-95ae-2c608917a663.png)

![image](https://user-images.githubusercontent.com/92590831/146295705-9935040c-1b95-4ee4-b7a6-7bff61c1b34c.png)

![image](https://user-images.githubusercontent.com/92590831/146295736-bad51771-b955-467e-a8dc-199aedbf9ac2.png)

![image](https://user-images.githubusercontent.com/92590831/146295742-be052eab-583b-4851-9d88-712f3c4acd68.png)

![image](https://user-images.githubusercontent.com/92590831/146295745-01977a9b-9b0f-458f-8a61-40b5a1d942d7.png)

![image](https://user-images.githubusercontent.com/92590831/146295752-61c1974d-2b3a-48c9-b24a-1d0e107faa0b.png)

![image](https://user-images.githubusercontent.com/92590831/146295761-81d5955c-77f2-4159-a6c0-e8c2aab5990d.png)

![image](https://user-images.githubusercontent.com/92590831/146295768-0264bf71-410e-4cc7-84e9-b9304ec40d8e.png)

![image](https://user-images.githubusercontent.com/92590831/146295770-01c5a4e6-2f3e-4bd2-a078-99a8e9cc0495.png)

![image](https://user-images.githubusercontent.com/92590831/146295774-78275f75-3682-43fe-a5ca-7339ab30fb90.png)

