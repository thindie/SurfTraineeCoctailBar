
### Привет! Спасибо за флоу!

>информацию о реализованной функциональности. В этой части должна быть информация:
Объем фичей, которые вы успели сделать и что не получилось. 

- Мои Коктейли, пусто
    - окей, кроме тени у ФАБа и пропорциональности элементов экрана
- Мои Коктейли, light
    - Дизайн ФАБ в обрамлении не сделан (решение - подключаю Материал2 -
      там были такие паттерны для боттом бар с вырезом, применяю Shape) / 2 часа
    - Не применял зардкоженные пикчи из дизайна, однако в целом место для
      комфортной вставки решения я сделал. для макс. удобства я бы написал
      асбтракцию, которая смогла бы работать с различными источниками данных
      (хардкод, галерея, ресурсы и проч) / тайминг будет связан с
      сопредельными кейсами, так что примерно 5 часов.
    - Проблема: проявляется экран "пусто" при наличии сохраненных в БД моделей
      Решение (LaunchedEffect на уровне компоуз, Более жадная валидация состояния
      во вьюмодели) / 20 мин
- Деталка Коктейля
    - В целом - можно было бы подумать о другой реализации сего события. На данный
      момент там BottomSheetScaffold, контент, по задумке - должен был занимать константное
      положение ввиду прямого отключения способности Боттом шита к eхpand и drag,
      и UI из проекта должен был воспроизвестись быстрее и легче. однако,
      как я сегодня выяснил - scroll behavior помещенного вовнутрь LazyList
      влияет на состояние BottomSheet - похоже, что явные флаги sheetSwipeEnable = false
      работают не корректно. Решение - мигрировать на Box () / 3 часа
    - Изображение - опять же - хардкод/плейсхолдер не сделан, но все готово для
      "пристойной" реализации, вопрос в поставке данных, как в "Мои коктейли" - решение
      этого кейса будет общим
    - По кнопке Edit - все прокинуто, экран ввода информации был готов принимать кейс
      с редактированием элемента, апи текстовых полей также без модификации могли бы обработать
      событие реадактирования сущесвующего элемента, в репозитории / дао - также
      логика была подведена / 30 минут до работающего функционала
- Добавление Коктейля
    - помимо не работающих так как бы хотелось textfield colorstate и arragement
      текста - все более менее
      (чипсы правда внезапно самописные оказались).
      
 >Технические детали реализации (Например: что вы используете для хранения данных или как происходит запрос в сеть)

  - Room, Flow, Compose with Plain State Holder classes, Clean на домене без Юзкейсов, Hilt, Compose Navigation.

      Оставшееся время бы оценил для себя в 10 - 11 часов чистой разработки.

    ![Screenshot_1](https://github.com/thindie/SurfTraineeCoctailBar/assets/93595798/33497222-a50a-40b0-a916-d21bb5464737)
    
    ![Screenshot_2](https://github.com/thindie/SurfTraineeCoctailBar/assets/93595798/cd904651-56ef-4439-a8ad-21c7de4e074a)
      ![Screenshot_3](https://github.com/thindie/SurfTraineeCoctailBar/assets/93595798/9b91f053-3c4f-41ee-a2bc-8293edac6a9a)
    ![Screenshot_5](https://github.com/thindie/SurfTraineeCoctailBar/assets/93595798/1c9a391f-d119-4f69-ad9e-159f64c52704)



      
  
