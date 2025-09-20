const form = document.getElementById('propertyForm');
const list = document.getElementById('propertyList');

// Crear nueva propiedad
form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const property = {
        address: document.getElementById('address').value,
        price: parseFloat(document.getElementById('price').value),
        size: parseFloat(document.getElementById('size').value),
        description: document.getElementById('description').value
    };

    await fetch('/api/properties', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(property)
    });

    form.reset();
    loadProperties();
});

// Cargar todas las propiedades
async function loadProperties() {
    const res = await fetch('/api/properties');
    const properties = await res.json();

    list.innerHTML = '';

    properties.forEach(p => {
        const li = document.createElement('li');
        li.textContent = `${p.address} - $${p.price} - ${p.size} sqm - ${p.description}`;

        // Botón eliminar
        const delBtn = document.createElement('button');
        delBtn.textContent = 'Delete';
        delBtn.onclick = async () => {
            await fetch(`/api/properties/${p.id}`, { method: 'DELETE' });
            loadProperties();
        };

        // Botón actualizar
        const editBtn = document.createElement('button');
        editBtn.textContent = 'Edit';
        editBtn.onclick = () => editProperty(p);

        li.appendChild(editBtn);
        li.appendChild(delBtn);
        list.appendChild(li);
    });
}

// Función para editar propiedad
function editProperty(property) {
    const address = prompt("Address:", property.address);
    const price = prompt("Price:", property.price);
    const size = prompt("Size:", property.size);
    const description = prompt("Description:", property.description);

    if (address != null && price != null && size != null && description != null) {
        fetch(`/api/properties/${property.id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                address: address,
                price: parseFloat(price),
                size: parseFloat(size),
                description: description
            })
        }).then(() => loadProperties());
    }
}


loadProperties();
