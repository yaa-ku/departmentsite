$(document).ready(()=> {
    console.log('CLICKED')
    document.getElementById('newsectionbtn').addEventListener('click',()=>{
        const node = document.createElement('div');
        node.className='block'
        const titleNode = document.createElement('input');
        titleNode.value='ok'
        titleNode.className='title'
        titleNode.type = 'text'
        const contentNode = document.createElement('textarea');
        contentNode.value='ok'
        contentNode.rows = 2
        contentNode.className='content'
        contentNode.type='text'

        const attach = document.createElement('div')
        attach.className = 'attach';
        const attachHead = document.createElement('div')
        attachHead.className = 'attach__head';
        attachHead.textContent = 'Прикрепите файлы (максимум 10 файлов):'
        const attachItem = document.createElement('div')
        attachItem.className = 'attach__item';
        const lbl = document.createElement('label');
        const attachUp = document.createElement('div')
        attachUp.className = 'attach__up'
        attachUp.textContent = 'Загрузить файл';
        const attachInput = document.createElement('input')
        attachInput.className = 'attach__input'
        attachInput.type = 'file';
        const attachName = document.createElement('div')
        attachName.className = 'attach__name';
        const attachDelete = document.createElement('div')
        attachDelete.textContent = 'Удалить'
        attachDelete.className = 'attach__delete';

        lbl.appendChild(attachUp);
        lbl.appendChild(attachInput);
        attachItem.appendChild(lbl);
        attachItem.appendChild(attachName);
        attachItem.appendChild(attachDelete);
        attach.appendChild(attachHead);
        attach.appendChild(attachItem);



        node.appendChild(titleNode);
        node.appendChild(document.createElement('br'))
        node.appendChild(contentNode);
        node.appendChild(document.createElement('br'))
        console.log('5')
        node.appendChild(attach)
        document.getElementById('formdata').appendChild(node);
        f()
    }, false)
    document.getElementById('submitNews').addEventListener('click',()=>{
        const name = $('#name').val()
        const description= $('#description').val()
        const content = $('.content')
        const titles = $('.title')

    }, false)
    document.getElementById('news').addEventListener('submit', (event)=> {

        alert('CLICKED1')
        const blocks = $('.block');

        for (const block of blocks) {
            alert('CLICKED2')
            alert(block.getElementsByClassName('content').length)
            alert(block.getElementsByClassName('title').length)
            alert(block.getElementsByClassName('attach__input').length)
        }



        const formData = {
            name: $('#name').val(),
            email: $('#description').val(),
            superheroAlias: $('#image_title').val(),

            content: $('.content'),
            titles: $('.title'),
            photo: [...$('.attach__input')]
        };
        formData.photo.pop()
        alert(typeof formData.photo)
        alert('NAME '+formData.name+' '+formData.email+' '+formData.superheroAlias)
        alert('TITLE '+[...formData.titles].map(input => input.value))
        alert('CONTENT '+[...formData.content].map(input => input.value))
        alert('FILES '+formData.photo.map(input => input.files.length))
        //
        // $.ajax({
        //     type: "POST",
        //     url: "process.php",
        //     data: formData,
        //     dataType: "json",
        //     encode: true,
        // }).done(function (data) {
        //     console.log(data);
        // });

        event.preventDefault();
    }, false);
        f();
}
);
function f(){
    $('.attach').each(function() {// на случай, если таких групп файлов будет больше одной
        let attach = $(this),
            fieldClass = 'attach__item', // класс поля
            attachedClass = 'attach__item--attached', // класс поля с файлом
            fields = attach.find('.' + fieldClass).length, // начальное кол-во полей
            fieldsAttached = 0; // начальное кол-во полей с файлами

        const newItem = '<div class="attach__item"><label><div class="attach__up">Добавить файл</div><input class="attach__input" type="file"/></label><div class="attach__name"></div><div class="attach__delete">Удалить</div></div>'; // разметка нового поля

        // При изменении инпута
        attach.on('change', '.attach__input', function(e) {
            let item = $(this).closest('.' + fieldClass),
                fileName = '';
            if (e.target.value) { // если value инпута не пустое
                fileName = e.target.value.split('\\').pop(); // оставляем только имя файла и записываем в переменную
            }
            if (fileName) { // если имя файла не пустое
                item.find('.attach__name').text(fileName); // подставляем в поле имя файла
                if (!item.hasClass(attachedClass)) { // если в поле до этого не было файла
                    item.addClass(attachedClass); // отмечаем поле классом
                    fieldsAttached++;
                }
                if (fields < 10 && fields === fieldsAttached) { // если полей меньше 10 и кол-во полей равно
                    item.after($(newItem)); // добавляем новое поле
                    fields++;
                }
            } else { // если имя файла пустое
                if (fields === fieldsAttached + 1) {
                    item.remove(); // удаляем поле
                    fields--;
                } else {
                    item.replaceWith($(newItem)); // заменяем поле на "чистое"
                }
                fieldsAttached--;

                if (fields === 1) { // если поле осталось одно
                    attach.find('.attach__up').text('Загрузить файл'); // меняем текст
                }
            }
        });

        // При нажатии на "Удалить"
        attach.on('click', '.attach__delete', function() {
            const item = $(this).closest('.' + fieldClass);
            if (fields > fieldsAttached) { // если полей больше, чем загруженных файлов
                item.remove(); // удаляем поле
                fields--;
            } else { // если равно
                item.after($(newItem)); // добавляем новое поле
                item.remove(); // удаляем старое
            }
            fieldsAttached--;
            if (fields === 1) { // если поле осталось одно
                attach.find('.attach__up').text('Загрузить файл'); // меняем текст
            }
        });
    });
}