import React from 'react';
import Search from "./Search";

const SearchNew = () => {
    const amp = <svg width="1em" height="1em" viewBox="0 0 16 16" className="bi bi-search" fill="currentColor"
                     xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd"
              d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"/>
        <path fill-rule="evenodd"
              d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"/>
    </svg>

    return (
        <div className="input-group mb-3">
            <div className="input-group-prepend">
                <button className="btn btn-primary" type="button" id="button-addon1">{amp}</button>
            </div>
            <input type="text" className="form-control" placeholder="Search" aria-label="Example text with button addon"
                   aria-describedby="button-addon1"/>
        </div>
    )
}

export default SearchNew;