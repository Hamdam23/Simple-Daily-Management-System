<style>
    .modal-header{
        display: flex;
        justify-content: space-between;
    }
    .modal-header{
        background-color: #1d588a;
    }
    .modal-title {
        color: #fff;
        font-weight: 600;
        font-size: 25px;
    }
    .modal-body{
        color: #000;
        font-weight: 600;
        font-size: 18px;
    }
    #modal-ok{
        color: #fff;
        background-color: #790707;
    }

</style>
<div class="modal hide" tabindex="-1" id="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header d-flex ">
                <h5 class="modal-title">Delete</h5>
            </div>
            <div class="modal-body">
                <p style="text-align: center">Delete this product?</p>
            </div>
            <div class="modal-footer">
                <button id="modal-ok" type="button" class="btn btn-secondary" data-bs-dismiss="modal">YES</button>
                <button id="modal-cancel" type="button" class="btn btn-primary">NO</button>
            </div>
        </div>
    </div>
</div>