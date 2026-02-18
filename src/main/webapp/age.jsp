<!DOCTYPE html>

<html class="dark" lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <title>Age Verification Gate | Premium Spirits</title>
    <script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap"
          rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@300;400;500;600;700&amp;display=swap"
          rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap"
          rel="stylesheet"/>
    <script id="tailwind-config">
        tailwind.config = {
            darkMode: "class",
            theme: {
                extend: {
                    colors: {
                        "primary": "#d41121",
                        "background-light": "#f8f6f6",
                        "background-dark": "#120809",
                    },
                    fontFamily: {
                        "display": ["Work Sans", "sans-serif"]
                    },
                    borderRadius: {"DEFAULT": "0.25rem", "lg": "0.5rem", "xl": "0.75rem", "full": "9999px"},
                },
            },
        }
    </script>
    <style>body {
        font-family: "Work Sans", sans-serif
    }

    .glass-panel {
        background: rgba(18, 8, 9, 0.85);
        backdrop-filter: blur(12px);
        border: 1px solid rgba(255, 255, 255, 0.1)
    }

    .blur-bg {
        background-image: url(https://lh3.googleusercontent.com/aida-public/AB6AXuAGdlA0X5Cuu8Auwg7FbQeQ_io0wU4mqbdYFQ80Jd8dDksWUncuLsMmz65qqBX1l5sGd2DV0jh5Z2BvkRKzZC9dLQgSE5LY5fwXhfVnmwqUwmeDoNN0oSuovCAoD0FZWoDCKZfXHlM-KX0aMgX3vyUz_ainO5oYVvv_cjhqgd-UtRDxrlAbmeijSo_CGEKBlGdsgRh0JJHEIRakpmfruxjH1RhgUdAXyj4JSWB3i_uDSqdmDof4MYk3zPDvzWeDFZj-blPBIuR-Olah);
        background-position: center;
        background-size: cover;
        filter: blur(8px) brightness(0.4);
        transform: scale(1.1)
    }</style>
</head>
<body class="bg-background-light dark:bg-background-dark overflow-hidden font-display">
<!-- Background Layer -->
<div class="fixed inset-0 z-0 blur-bg" data-alt="blurred premium bar with bottles and warm lighting"></div>
<!-- Main Content Container -->
<div class="relative z-10 flex min-h-screen items-center justify-center p-4">
    <!-- Verification Card -->
    <div class="glass-panel w-full max-w-[520px] rounded-xl p-8 md:p-12 flex flex-col items-center shadow-2xl">
        <!-- Brand Logo / Icon -->
        <div class="mb-8 flex flex-col items-center">
            <div class="w-16 h-16 bg-primary rounded-full flex items-center justify-center mb-4 shadow-lg shadow-primary/20">
                <span class="material-symbols-outlined text-white text-4xl" data-icon="liquor">liquor</span>
            </div>
            <h2 class="text-white text-xs tracking-[0.4em] uppercase font-light opacity-80">Reserved Access</h2>
        </div>
        <!-- Header Section -->
        <h1 class="text-white tracking-tight text-[32px] md:text-[40px] font-bold leading-tight text-center pb-2">
            Experience Excellence
        </h1>
        <p class="text-white/70 text-base font-normal leading-relaxed pb-8 text-center max-w-sm">
            You must be of legal drinking age in your country to enter the premium collection.
        </p>
        <!-- Date Selection Form -->
        <div class="w-full flex flex-col gap-6">
            <div class="grid grid-cols-3 gap-4">
                <!-- Day -->
                <label class="flex flex-col flex-1">
                    <p class="text-white/60 text-xs font-medium uppercase tracking-widest pb-2">Day</p>
                    <input class="form-input flex w-full rounded-lg text-white focus:outline-0 focus:ring-1 focus:ring-primary border border-white/10 bg-white/5 focus:border-primary h-14 placeholder:text-white/30 p-4 text-center text-lg font-medium transition-all"
                           placeholder="DD" type="number"/>
                </label>
                <!-- Month -->
                <label class="flex flex-col flex-1">
                    <p class="text-white/60 text-xs font-medium uppercase tracking-widest pb-2">Month</p>
                    <input class="form-input flex w-full rounded-lg text-white focus:outline-0 focus:ring-1 focus:ring-primary border border-white/10 bg-white/5 focus:border-primary h-14 placeholder:text-white/30 p-4 text-center text-lg font-medium transition-all"
                           placeholder="MM" type="number"/>
                </label>
                <!-- Year -->
                <label class="flex flex-col flex-1">
                    <p class="text-white/60 text-xs font-medium uppercase tracking-widest pb-2">Year</p>
                    <input class="form-input flex w-full rounded-lg text-white focus:outline-0 focus:ring-1 focus:ring-primary border border-white/10 bg-white/5 focus:border-primary h-14 placeholder:text-white/30 p-4 text-center text-lg font-medium transition-all"
                           placeholder="YYYY" type="number"/>
                </label>
            </div>
            <!-- Remember Me Toggle -->
            <div class="flex items-center justify-center gap-3 py-2">
                <input class="w-4 h-4 rounded border-white/20 bg-white/5 text-primary focus:ring-primary focus:ring-offset-0 transition-colors"
                       id="remember" type="checkbox"/>
                <label class="text-white/60 text-sm font-normal cursor-pointer hover:text-white transition-colors"
                       for="remember">Remember me for 30 days</label>
            </div>
            <!-- CTA Button -->
            <button class="w-full bg-primary hover:bg-primary/90 text-white font-bold py-5 px-8 rounded-lg text-lg uppercase tracking-widest transition-all active:scale-[0.98] shadow-xl shadow-primary/30 mt-2">
                Enter Shop
            </button>
        </div>
        <!-- Footer Compliance -->
        <div class="mt-10 border-t border-white/10 pt-6 w-full text-center">
            <p class="text-white/40 text-[11px] leading-relaxed px-4">
                By clicking "Enter Shop", you agree to our <a class="underline hover:text-white/60 transition-colors"
                                                              href="#">Terms of Service</a> and <a
                    class="underline hover:text-white/60 transition-colors" href="#">Privacy Policy</a>. Please enjoy
                our spirits responsibly. We do not share your personal information.
            </p>
        </div>
    </div>
    <!-- Social Proof/Extra Info -->
    <div class="absolute bottom-8 left-0 right-0 flex justify-center gap-8 text-white/40">
        <div class="flex items-center gap-2">
            <span class="material-symbols-outlined text-sm">verified_user</span>
            <span class="text-xs uppercase tracking-tighter">Secure Checkout</span>
        </div>
        <div class="flex items-center gap-2">
            <span class="material-symbols-outlined text-sm">local_shipping</span>
            <span class="text-xs uppercase tracking-tighter">Global Delivery</span>
        </div>
        <div class="flex items-center gap-2">
            <span class="material-symbols-outlined text-sm">workspace_premium</span>
            <span class="text-xs uppercase tracking-tighter">Authenticity Guaranteed</span>
        </div>
    </div>
</div>
</body>
</html>