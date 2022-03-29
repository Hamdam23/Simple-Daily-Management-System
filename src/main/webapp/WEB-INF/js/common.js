function deleteProfile(id) {
    document.querySelector('#modal').classList.remove('hide');
    document.querySelector('#modal-ok').addEventListener('click', ()=> {
        location.href = '/delete-product?id=' + id;
    });
    document.querySelector('#modal-cancel').addEventListener('click', ()=> {
        document.querySelector('#modal').classList.add('hide');
    })
}

function deleteProfile(id) {
    document.querySelector('#modal').classList.remove('hide');
    document.querySelector('#modal-ok').addEventListener('click', ()=> {
        location.href = '/delete-todo?id=' + id;
    });
    document.querySelector('#modal-cancel').addEventListener('click', ()=> {
        document.querySelector('#modal').classList.add('hide');
    })
}

function deleteProfile(id) {
    document.querySelector('#modal').classList.remove('hide');
    document.querySelector('#modal-ok').addEventListener('click', ()=> {
        location.href = '/delete-category?id=' + id;
    });
    document.querySelector('#modal-cancel').addEventListener('click', ()=> {
        document.querySelector('#modal').classList.add('hide');
    })
}