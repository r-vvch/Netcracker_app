# Ветка console
Содержит в себе версию приложения с реализацией обычного консольного приложения.

## Фукнционал
Ведение списков дел через консоль.  

### Возможности
Хранение/загрузка всех списков дел из памяти;

Для списков дел:
- создавать
- удалять
- переименовывать
- выбирать конкретный, и работать с его задачами

Для задач:
- создавать
- удалять
- переименовывать
- устанавливать выполненной/невыполненной

## Реализация
В пакете [entities](https://gitlab.com/edu-netcracker/group-2020/edu-rovo-own/-/tree/console/ToDo/src/main/java/com/edu_netcracker/todolist/entities) — сущности: задача, список задач;  
В пакете [services](https://gitlab.com/edu-netcracker/group-2020/edu-rovo-own/-/tree/console/ToDo/src/main/java/com/edu_netcracker/todolist/services) — интерфейсы для управления всем приложением, задания id, сохранения списка и их реализации. 
