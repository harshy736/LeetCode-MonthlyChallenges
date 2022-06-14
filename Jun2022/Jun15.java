<div class="my 3">
    <h4>Add a Todo</h4>
    <form (ngSubmit)="onSubmit()">
        <div class="mb-3">
            <label for="title" class="form">Todo Title</label>
            <input type="text" [(ngModel)]="title" class="form-control" id="title" name="title" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label class="form" for="desc">Todo Description</label>
            <input type="text" [(ngModel)]="desc" class="form-control" id="desc" name="desc">
        </div>
        <button type="submit" class="btn btn-sm btn-primary">Add Todo</button>
    </form>    
</div>
