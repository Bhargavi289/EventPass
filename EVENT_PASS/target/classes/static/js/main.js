// REGISTER USER
document.getElementById('registerForm')?.addEventListener('submit', async (e) => {
    e.preventDefault();
    const user = {
        fname: document.getElementById('fname').value,
        lname: document.getElementById('lname').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
        phoneNumber: document.getElementById('phone').value,
        securityQuestion: document.getElementById('securityQuestion').value
    };

    try {
        const res = await fetch("http://localhost:8080/api/users/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user)
        });

        if (res.ok) {
            alert("✅ Registration successful!");
            window.location.href = "login.html";
        } else {
            alert("❌ Registration failed!");
        }
    } catch (err) {
        console.error(err);
        alert("Server not reachable!");
    }
});

// LOGIN USER
document.getElementById('loginForm')?.addEventListener('submit', async (e) => {
    e.preventDefault();
    const credentials = {
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    try {
        const res = await fetch("http://localhost:8080/api/users/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(credentials)
        });

        if (res.ok) {
            const data = await res.json();
            alert(`✅ Welcome, ${data.fname}!`);
            localStorage.setItem("userId", data.id);
            window.location.href = "events.html";
        } else {
            alert("❌ Invalid credentials!");
        }
    } catch (err) {
        console.error(err);
        alert("Server not reachable!");
    }
});

