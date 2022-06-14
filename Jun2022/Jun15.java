<div class="my-3">
    <h5 [ngClass]="{'strike': !todo.active}">{{todo.title}}</h5>
    <p [ngClass]="{'strike': !todo.active}">{{todo.desc}}</p>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" (click)="onCheckBoxClick(todo)" [checked] = "!todo.active">
        <label class="form-check-label" for="todo{{i}}">Done</label>
      </div>
    <button class="btn btn-sm btn-danger" (click) = "onClick(todo)">Delete</button>
</div> 
