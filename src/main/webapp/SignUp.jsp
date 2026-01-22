<!DOCTYPE html>
<html class="dark" lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <title>Create Your Account | SpiritReserve</title>
    <script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
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
                        "background-dark": "#221012",
                    },
                    fontFamily: {
                        "display": ["Work Sans", "sans-serif"]
                    },
                    borderRadius: {"DEFAULT": "0.25rem", "lg": "0.5rem", "xl": "0.75rem", "full": "9999px"},
                },
            },
        }
    </script>
    <style type="text/tailwindcss">
        body {
            font-family: "Work Sans", sans-serif;
        }

        .glass-effect {
            background: rgba(34, 16, 18, 0.85);
            backdrop-filter: blur(12px);
            border: 1px solid rgba(212, 17, 33, 0.15);
        }

        input[type="date"]::-webkit-calendar-picker-indicator {
            filter: invert(1);
            opacity: 0.5;
            cursor: pointer;
        }
    </style>
</head>
<body class="bg-background-light dark:bg-background-dark min-h-screen flex flex-col">
<header class="fixed top-0 w-full z-50 flex items-center justify-between whitespace-nowrap border-b border-solid border-[#39282a]/30 px-10 py-3 bg-background-dark/80 backdrop-blur-md">
    <div class="flex items-center gap-4 text-white">
        <div class="size-6 text-primary">
            <svg fill="none" viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg">
                <path clip-rule="evenodd"
                      d="M12.0799 24L4 19.2479L9.95537 8.75216L18.04 13.4961L18.0446 4H29.9554L29.96 13.4961L38.0446 8.75216L44 19.2479L35.92 24L44 28.7521L38.0446 39.2479L29.96 34.5039L29.9554 44H18.0446L18.04 34.5039L9.95537 39.2479L4 28.7521L12.0799 24Z"
                      fill="currentColor" fill-rule="evenodd"></path>
            </svg>
        </div>
        <h2 class="text-white text-xl font-bold leading-tight tracking-[-0.015em] font-display">SpiritReserve</h2>
    </div>
    <div class="flex flex-1 justify-end gap-8">
        <div class="flex items-center gap-9">
            <a class="text-white/80 hover:text-white text-sm font-medium leading-normal transition-colors"
               href="#">Shop</a>
            <a class="text-white/80 hover:text-white text-sm font-medium leading-normal transition-colors" href="#">Collections</a>
            <a class="text-white/80 hover:text-white text-sm font-medium leading-normal transition-colors" href="#">Distilleries</a>
            <a class="text-white/80 hover:text-white text-sm font-medium leading-normal transition-colors" href="#">About</a>
        </div>
        <button class="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-lg h-10 px-5 bg-primary text-white text-sm font-bold leading-normal tracking-[0.015em] hover:bg-primary/90 transition-all">
            <span class="truncate">Join Club</span>
        </button>
    </div>
</header>
<main class="relative flex-1 flex items-center justify-center pt-24 pb-12">
    <div class="absolute inset-0 z-0">
        <div class="w-full h-full bg-center bg-no-repeat bg-cover"
             style='background-image: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.8)), url("https://lh3.googleusercontent.com/aida-public/AB6AXuDZZjafJ7O8wCxPPPtGn_VNuZ-599DhU99iKQlduYxHbDeete2-1ac9cqI60FDJHIKe0MIQgVLtC_Ftv7KuCIb6sAKFlq_2gVqjDaDb-_-2FR-nsVpaz8dLe7XoYhMg1ITfpX6BSCZuoDRp2OI6daqexUfJ89DbBXB0S05xUYgFAgGqkmUnruY0M50ASqmT3C3BmkN47gff6Wi7hkDOPXSz-b1kAKuwupMJk0aB-xunErvc2fmRxXGebXK1sG0EKRpBue7_mw2G-RiF");'>
        </div>
    </div>
    <div class="relative z-10 w-full max-w-[520px] px-6">
        <div class="glass-effect rounded-xl p-8 shadow-2xl flex flex-col">
            <div class="text-center mb-8">
                <h1 class="text-white tracking-light text-[32px] font-bold leading-tight pb-2 font-display">Create Your
                    Account</h1>
                <p class="text-white/70 text-base font-normal leading-normal">Join our exclusive community of spirit
                    enthusiasts.</p>
            </div>
            <form class="flex flex-col gap-5">
                <div class="flex flex-col gap-1.5">
                    <label class="text-white text-sm font-medium leading-normal px-1">Full Name</label>
                    <input class="form-input flex w-full rounded-lg text-white focus:outline-0 focus:ring-1 focus:ring-primary border border-[#543b3d] bg-[#271c1c]/60 focus:border-primary h-12 placeholder:text-[#b99d9f]/50 px-4 text-base font-normal leading-normal transition-all"
                           placeholder="John Doe" type="text"/>
                </div>
                <div class="flex flex-col gap-1.5">
                    <label class="text-white text-sm font-medium leading-normal px-1">Email Address</label>
                    <input class="form-input flex w-full rounded-lg text-white focus:outline-0 focus:ring-1 focus:ring-primary border border-[#543b3d] bg-[#271c1c]/60 focus:border-primary h-12 placeholder:text-[#b99d9f]/50 px-4 text-base font-normal leading-normal transition-all"
                           placeholder="name@example.com" type="email"/>
                </div>
                <div class="grid grid-cols-1 md:grid-cols-2 gap-5">
                    <div class="flex flex-col gap-1.5">
                        <label class="text-white text-sm font-medium leading-normal px-1">Password</label>
                        <input class="form-input flex w-full rounded-lg text-white focus:outline-0 focus:ring-1 focus:ring-primary border border-[#543b3d] bg-[#271c1c]/60 focus:border-primary h-12 placeholder:text-[#b99d9f]/50 px-4 text-base font-normal leading-normal transition-all"
                               placeholder="••••••••" type="password"/>
                    </div>
                    <div class="flex flex-col gap-1.5">
                        <label class="text-white text-sm font-medium leading-normal px-1">Date of Birth</label>
                        <input class="form-input flex w-full rounded-lg text-white focus:outline-0 focus:ring-1 focus:ring-primary border border-[#543b3d] bg-[#271c1c]/60 focus:border-primary h-12 placeholder:text-[#b99d9f]/50 px-4 text-base font-normal leading-normal transition-all"
                               type="date"/>
                    </div>
                </div>
                <div class="flex items-start gap-3 px-1 mt-1">
                    <input class="mt-1 w-4 h-4 rounded border-[#543b3d] bg-[#271c1c] text-primary focus:ring-primary focus:ring-offset-background-dark"
                           id="terms" required="" type="checkbox"/>
                    <label class="text-white/70 text-xs leading-normal cursor-pointer" for="terms">
                        I certify that I am of legal drinking age in my country of residence and agree to the Terms of
                        Service.
                    </label>
                </div>
                <button class="w-full bg-primary hover:bg-primary/90 text-white font-bold py-3.5 rounded-lg transition-all mt-2 shadow-lg shadow-primary/20"
                        type="submit">
                    Create Account
                </button>
            </form>
            <div class="relative flex py-6 items-center">
                <div class="flex-grow border-t border-[#543b3d]"></div>
                <span class="flex-shrink mx-4 text-[#b99d9f] text-xs font-medium uppercase tracking-widest">or continue with</span>
                <div class="flex-grow border-t border-[#543b3d]"></div>
            </div>
            <div class="grid grid-cols-2 gap-4">
                <button class="flex items-center justify-center gap-2 h-11 rounded-lg border border-[#543b3d] bg-[#271c1c]/40 hover:bg-[#271c1c]/80 text-white text-sm font-medium transition-all">
                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24">
                        <path d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z"
                              fill="#4285F4"></path>
                        <path d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z"
                              fill="#34A853"></path>
                        <path d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l2.85-2.22.81-.62z"
                              fill="#FBBC05"></path>
                        <path d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 12-4.53z"
                              fill="#EA4335"></path>
                    </svg>
                    Google
                </button>
                <button class="flex items-center justify-center gap-2 h-11 rounded-lg border border-[#543b3d] bg-[#271c1c]/40 hover:bg-[#271c1c]/80 text-white text-sm font-medium transition-all">
                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 24 24">
                        <path d="M17.05 20.28c-.96.95-2.04 1.44-3.23 1.45-1.18.01-2.18-.32-3.19-.33-1.01 0-2.18.33-3.24.32-1.19-.01-2.27-.49-3.21-1.43-1.96-1.95-2.92-5.45-1.91-7.98.51-1.28 1.48-2.09 2.58-2.11 1.02-.01 1.83.47 2.6.47.74 0 1.76-.59 2.94-.52 1.25.07 2.27.53 2.97 1.49-2.5 1.48-1.9 4.88.58 5.89-.5 1.25-1.14 2.45-1.89 3.25zM12.03 7.25c-.15-2.23 1.66-4.07 3.74-4.25.19 2.31-2.06 4.28-3.74 4.25z"></path>
                    </svg>
                    Apple
                </button>
            </div>
            <p class="text-center text-white/60 text-sm mt-8">
                Already have an account?
                <a class="text-primary font-semibold hover:underline ml-1" href="#">Sign In</a>
            </p>
        </div>
    </div>
</main>
<footer class="bg-background-dark py-6 px-10 border-t border-[#39282a]">
    <div class="max-w-7xl mx-auto flex flex-col md:flex-row justify-between items-center gap-4 text-xs text-[#b99d9f]/60">
        <div class="flex items-center gap-2">
            <span class="material-symbols-outlined text-sm">verified_user</span>
            <span>You must be 21+ to enter this site. Please drink responsibly.</span>
        </div>
        <div class="flex gap-6">
            <a class="hover:text-primary transition-colors" href="#">Privacy Policy</a>
            <a class="hover:text-primary transition-colors" href="#">Terms of Service</a>
            <a class="hover:text-primary transition-colors" href="#">Cookie Policy</a>
        </div>
        <p>© 2024 SpiritReserve. All rights reserved.</p>
    </div>
</footer>

</body>
</html>