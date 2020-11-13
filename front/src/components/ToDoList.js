import React from 'react';
// import ReactDOM from 'react-dom';

import Task from "./Task";

const ToDoList = ({ toDoList }) => {
    const tasks = toDoList.map((item) => {
        return (
            <li key = {item.key}>
                <Task name={item.name} isImportant={item.isImportant} />
            </li>
        )
    })
    return (
        <ul>
            {tasks}
        </ul>
    )
}

export default ToDoList;
