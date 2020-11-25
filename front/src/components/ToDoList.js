    import React from 'react';
// import ReactDOM from 'react-dom';

import Task from "./Task";

const ToDoList = ({ toDoList }) => {
    const tasks = toDoList.map((item) => {
        if (item.isImportant) {
            return (
                <li class="list-group-item d-flex justify-content-between align-items-center" key={item.key}>
                    <Task name={item.name} isImportant={item.isImportant}/>
                    <span className="badge badge-primary badge-pill">!</span>
                </li>
            )
        } else {
            return (
                    <li className="list-group-item" key={item.key}>
                        <Task name={item.name} isImportant={item.isImportant}/>
                    </li>
                )
        }
    })
    return (
        <ul class="list-group">
            {tasks}
        </ul>
    )
}

export default ToDoList;
