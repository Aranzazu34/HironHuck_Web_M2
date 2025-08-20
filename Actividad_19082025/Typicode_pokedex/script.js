const postContenedor = document.getElementById('posts');

fetch('https://jsonplaceholder.typicode.com/posts?_limit=20')
    .then(response => response.json())
    .then(data => {
        console.log(data);
        data.forEach(post => {
            const postDiv = document.createElement('div');
            postDiv.classList.add('post');
            postDiv.innerHTML = `
                <h2>${post.title}</h2>
                <p>${post.body}</p>
            `;
            postContenedor.appendChild(postDiv);
        });
    })
    .catch(error => console.error('Error fetching posts:', error));
