document.getElementById('signupForm').addEventListener('submit', function (e){
    const firstName = document.getElementById('fName').value;
    const lastName = document.getElementById('lName').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (password.length < 8){
        e.preventDefault();
        alert('Password must be at least 8 characters long!');
        return false;
    }

    const emailPatern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPatern.test(email)){
        e.preventDefault();
        alert('Please enter a valid email address !');
        return false;
    }

    if (mobile && mobile.trim() !== ''){
        const mobilePatern = /^[\d\s\-\+\(\)]+$/;
        if (!mobilePatern.test(mobile) || mobile.replace(/\D/g, '').length < 10){
            e.preventDefault();
            alert('Please enter a valid mobile !');
            return false;
        }
    }
    return true;
});