function deleteProfile(id) {
    document.querySelector('#modal').classList.remove('hide');
    document.querySelector('#modal-ok').addEventListener('click', ()=> {
        location.href = '/delete-product?id=' + id;
    });
    document.querySelector('#modal-cancel').addEventListener('click', ()=> {
        document.querySelector('#modal').classList.add('hide');
    })
}