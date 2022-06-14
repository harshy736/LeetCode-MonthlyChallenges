<div class="container">
    <h1 class="text-center mb-5">Todo List By Harsh</h1>
<app-add-todo (todoAdd)="addTodo($event)"></app-add-todo>
<div class="my-4">
    <h4>Your Todos</h4>
    <div *ngIf="this.todos.length===0; else elseBlock">No Todos to display</div>
    <ng-template #elseBlock>
        <div *ngFor = "let todo of todos; index as i">
            <app-todo-item [todo] = "todo" [i]="i" (todoDelete)="deleteTodo($event)" (todoCheckBox)="toggleTodo($event)"></app-todo-item>
        </div> 
    </ng-template>
</div>
</div>
