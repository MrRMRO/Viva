<!DOCTYPE html>

<html class="dark" lang="en"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>SpiritLuxury | Premium Liquor Store</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@300;400;500;600;700;900&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<script id="tailwind-config">
        tailwind.config = {
            darkMode: "class",
            theme: {
                extend: {
                    colors: {
                        "primary": "#d41121",
                        "accent-gold": "#C5A059",
                        "background-light": "#f8f6f6",
                        "background-dark": "#121212",
                    },
                    fontFamily: {
                        "display": ["Work Sans"]
                    },
                    borderRadius: {"DEFAULT": "0.25rem", "lg": "0.5rem", "xl": "0.75rem", "full": "9999px"},
                },
            },
        }
    </script>
<style>
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24;
        }
        body {
            font-family: 'Work Sans', sans-serif;
        }
    </style>
</head>
<body class="bg-background-light dark:bg-background-dark text-slate-900 dark:text-slate-100 min-h-screen">
<!-- Top Navigation Bar -->
<header class="sticky top-0 z-50 w-full border-b border-white/10 bg-background-light/80 dark:bg-background-dark/80 backdrop-blur-md">
<div class="max-w-[1200px] mx-auto px-6 py-4 flex items-center justify-between">
<div class="flex items-center gap-10">
<div class="flex items-center gap-3">
<div class="size-8 text-primary flex items-center justify-center">
<span class="material-symbols-outlined text-3xl">liquor</span>
</div>
<h1 class="text-xl font-black tracking-tighter uppercase dark:text-white">SpiritLuxury</h1>
</div>
<nav class="hidden md:flex items-center gap-8">
<a class="text-sm font-medium hover:text-primary transition-colors" href="#">Shop</a>
<a class="text-sm font-medium hover:text-primary transition-colors" href="#">Collections</a>
<a class="text-sm font-medium hover:text-primary transition-colors" href="#">Connoisseurs</a>
<a class="text-sm font-medium hover:text-primary transition-colors" href="#">About</a>
</nav>
</div>
<div class="flex items-center gap-6">
<div class="relative hidden lg:block group">
<input class="w-64 h-10 pl-10 pr-4 rounded-lg bg-black/20 dark:bg-white/10 border-none focus:ring-1 focus:ring-accent-gold transition-all text-sm placeholder:text-slate-500" placeholder="Search rare whiskies..." type="text"/>
<span class="material-symbols-outlined absolute left-3 top-2.5 text-slate-400 text-sm">search</span>
</div>
<div class="flex items-center gap-4">
<button class="relative p-2 hover:bg-white/5 rounded-full transition-colors">
<span class="material-symbols-outlined">shopping_cart</span>
<span class="absolute top-1 right-1 size-4 bg-primary text-[10px] font-bold text-white flex items-center justify-center rounded-full">3</span>
</button>
<button class="p-2 hover:bg-white/5 rounded-full transition-colors">
<span class="material-symbols-outlined">person</span>
</button>
</div>
</div>
</div>
</header>
<main class="max-w-[1200px] mx-auto pb-20">
<!-- Hero Section -->
<section class="p-6">
<div class="relative h-[600px] w-full rounded-xl overflow-hidden group">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-700 group-hover:scale-105" data-alt="Luxurious dark shelf with premium whiskey bottles and amber lighting" style='background-image: linear-gradient(to right, rgba(0,0,0,0.8) 0%, rgba(0,0,0,0.2) 100%), url("https://lh3.googleusercontent.com/aida-public/AB6AXuBNapUvMVNJofaoWwn1stHR92-0qq_etnwGxlYyZn434NmeH--e7bE2OHU-9a_3x2gMM1RuO07hi4c5LWponsF3aigLmuLhH7UU5JEVgZSrnDpctTTY3USWdL4crWq_Mp61Zq2bKG1TCIR3hXk87Cphk-3NYrBJ7cQc_En8l25Ey8B_q4J21pFVMUljBh0DBk8Hlu-d99jl5i1FVstIJR17Net1iElvWeUfg110rheP8yhl5wUq454W2QwAchMpS4DQZuClRD5VkAgS");'>
</div>
<div class="relative h-full flex flex-col justify-center px-16 max-w-2xl gap-6">
<span class="text-accent-gold font-semibold tracking-widest uppercase text-sm">Limited Edition Release</span>
<h2 class="text-white text-5xl md:text-6xl font-black leading-tight">Exquisite Spirits for the Refined Palate</h2>
<p class="text-slate-300 text-lg">Experience the depth of our curated rare malts and artisanal limited batches from the world's most prestigious distilleries.</p>
<div class="flex gap-4">
<button class="px-8 py-4 bg-primary hover:bg-primary/90 text-white font-bold rounded-lg transition-all transform hover:-translate-y-1 shadow-lg shadow-primary/20">
                            Explore Whiskey
                        </button>
<button class="px-8 py-4 bg-white/10 hover:bg-white/20 backdrop-blur-sm text-white font-bold rounded-lg border border-white/20 transition-all">
                            New Arrivals
                        </button>
</div>
</div>
</div>
</section>
<!-- Promotional Strip -->
<section class="px-6 py-4">
<div class="bg-accent-gold/10 border border-accent-gold/20 rounded-lg p-4 flex flex-wrap items-center justify-center gap-12 text-accent-gold">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined">verified</span>
<span class="text-xs font-bold uppercase tracking-wider">Certified Authenticity</span>
</div>
<div class="flex items-center gap-2 border-l border-accent-gold/20 pl-12 hidden md:flex">
<span class="material-symbols-outlined">local_shipping</span>
<span class="text-xs font-bold uppercase tracking-wider">Free Shipping over $250</span>
</div>
<div class="flex items-center gap-2 border-l border-accent-gold/20 pl-12 hidden md:flex">
<span class="material-symbols-outlined">loyalty</span>
<span class="text-xs font-bold uppercase tracking-wider">Connoisseur Club Perks</span>
</div>
</div>
</section>
<!-- Trending Spirits -->
<section class="py-12">
<div class="px-6 flex items-center justify-between mb-8">
<div>
<h3 class="text-3xl font-bold dark:text-white">Trending Spirits</h3>
<p class="text-slate-500 mt-1">Our most coveted selections this month.</p>
</div>
<a class="text-primary font-bold flex items-center gap-1 hover:underline" href="#">
                    View all <span class="material-symbols-outlined text-sm">arrow_forward</span>
</a>
</div>
<div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6 px-6">
<!-- Product Card 1 -->
<div class="group bg-white dark:bg-white/5 rounded-xl overflow-hidden border border-transparent hover:border-accent-gold/30 transition-all">
<div class="aspect-[4/5] bg-slate-200 dark:bg-white/10 relative overflow-hidden">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-500 group-hover:scale-110" data-alt="Elegant amber whiskey bottle in studio lighting" style='background-image: url("https://lh3.googleusercontent.com/aida-public/AB6AXuC6ZZj6ESf5mufIcQqVywI3sN4ePCAFxi0h9c6Cz6FJjrUbOfz1KRIa1Cp0R8-pgFLsTISJMBMffMx7wp1LKjLmZ6uSgRBYfgdMOaY6sQ3V5P7gXycD7rGFz0ks6cHWLYMp6cRsseImbvBCkqBTSbmpnbgj7pbR4VsljO0FkPcnJemHmZ3j0SIEs76QuaULMANwBP3pcL1qNovCdCCNGoH105KePH2ZPs6idMto9SbUOcMgud5cifyoaJiDYc6MhwHpHkReyAItWCix");'></div>
<div class="absolute top-4 left-4 bg-primary text-white text-[10px] font-black px-2 py-1 rounded-full uppercase tracking-tighter">Bestseller</div>
<button class="absolute bottom-4 right-4 size-10 bg-white text-black rounded-full flex items-center justify-center opacity-0 translate-y-2 group-hover:opacity-100 group-hover:translate-y-0 transition-all shadow-xl">
<span class="material-symbols-outlined">add_shopping_cart</span>
</button>
</div>
<div class="p-4">
<p class="text-[10px] text-accent-gold font-bold uppercase mb-1">Highland Single Malt</p>
<h4 class="font-bold text-lg leading-tight mb-2">The Golden Cask 18yr</h4>
<div class="flex items-center justify-between">
<span class="text-xl font-black text-primary">$189.00</span>
<div class="flex items-center gap-1">
<span class="material-symbols-outlined text-accent-gold text-xs fill-1">star</span>
<span class="text-xs font-medium">4.9</span>
</div>
</div>
</div>
</div>
<!-- Product Card 2 -->
<div class="group bg-white dark:bg-white/5 rounded-xl overflow-hidden border border-transparent hover:border-accent-gold/30 transition-all">
<div class="aspect-[4/5] bg-slate-200 dark:bg-white/10 relative overflow-hidden">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-500 group-hover:scale-110" data-alt="Modern geometric gin bottle with botanical design" style='background-image: url("https://lh3.googleusercontent.com/aida-public/AB6AXuCk1pPozeiT1Ml-mVNWZ4I8Bz2aJPhZspg-JgqvAw4T-qfe7zLHJC-6ejmtssjzKMTQHFks7BeiKgH0wJI2Mad4rikEh8NNTqb-xyfkX-MA9h-fY7C8AOXi6osO25gf0ACo9rx40h9mpW-f9N7z5yM0wBbxyO6qjd2zRgcxPxGOCsKihm0WfPYKByOuYdVCdWQnwpZBLLQhCnmYx4yVgeKZ-tmI6Irn_XV9-31HtGeyR8Ua6-o9pK678B2disMOYO0R6Seaw-arULy7");'></div>
<button class="absolute bottom-4 right-4 size-10 bg-white text-black rounded-full flex items-center justify-center opacity-0 translate-y-2 group-hover:opacity-100 group-hover:translate-y-0 transition-all shadow-xl">
<span class="material-symbols-outlined">add_shopping_cart</span>
</button>
</div>
<div class="p-4">
<p class="text-[10px] text-accent-gold font-bold uppercase mb-1">Artisanal Gin</p>
<h4 class="font-bold text-lg leading-tight mb-2">Botanical No. 7 Reserve</h4>
<div class="flex items-center justify-between">
<span class="text-xl font-black text-primary">$65.00</span>
<div class="flex items-center gap-1">
<span class="material-symbols-outlined text-accent-gold text-xs fill-1">star</span>
<span class="text-xs font-medium">4.8</span>
</div>
</div>
</div>
</div>
<!-- Product Card 3 -->
<div class="group bg-white dark:bg-white/5 rounded-xl overflow-hidden border border-transparent hover:border-accent-gold/30 transition-all">
<div class="aspect-[4/5] bg-slate-200 dark:bg-white/10 relative overflow-hidden">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-500 group-hover:scale-110" data-alt="Premium dark rum bottle on mahogany surface" style='background-image: url("https://lh3.googleusercontent.com/aida-public/AB6AXuBPzdJiHXWMv-9AbYBVK-WWRrsql5bBob4BlBmDRzOqJmXu03o1ZPl667pliQ2gGHYZjwdRjfuQZQ2Fl06GMzmbq9wUBZH9nN7wdU2q9_8u1gxd-yaPY6vLxvpL4xopBnUp3HCQ76j2949HNDIN8s9is6CExQVC13zEtKqmUFE419NURC7aeKHPomxUBBQJkPykZD1pzqIu_anFkGRmNAR4ZF2zJ7rQD_gT6lpGUzj1eqjYiPBU0TALQHoXcRX7pVLQfblLKEfkya79");'></div>
<button class="absolute bottom-4 right-4 size-10 bg-white text-black rounded-full flex items-center justify-center opacity-0 translate-y-2 group-hover:opacity-100 group-hover:translate-y-0 transition-all shadow-xl">
<span class="material-symbols-outlined">add_shopping_cart</span>
</button>
</div>
<div class="p-4">
<p class="text-[10px] text-accent-gold font-bold uppercase mb-1">Aged Rum</p>
<h4 class="font-bold text-lg leading-tight mb-2">Heritage Spiced 25yr</h4>
<div class="flex items-center justify-between">
<span class="text-xl font-black text-primary">$120.00</span>
<div class="flex items-center gap-1">
<span class="material-symbols-outlined text-accent-gold text-xs fill-1">star</span>
<span class="text-xs font-medium">5.0</span>
</div>
</div>
</div>
</div>
<!-- Product Card 4 -->
<div class="group bg-white dark:bg-white/5 rounded-xl overflow-hidden border border-transparent hover:border-accent-gold/30 transition-all">
<div class="aspect-[4/5] bg-slate-200 dark:bg-white/10 relative overflow-hidden">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-500 group-hover:scale-110" data-alt="Luxury champagne bottle in ice bucket" style='background-image: url("https://lh3.googleusercontent.com/aida-public/AB6AXuDp32tt144VETdPtn5p2F8mn-xpTd2BX5svBh_VMZ9FCaYAZlkjsphkJGmLG1CO3NpyTzG-T-8e8mOWnEOiMIAq_otUi2v9BvbNzIE3J5Krw1LGLX5FLB6jYeepkVQilt3lR0c16z6fQrza0kdvEtKZ0VEixY9ddM3whuHFBwq5MT3HVlWxnJO23mM54PHlIbgh9ZT6IMSd4r4u7TpjJnTozVjxZBchY-YaiNCfDjtW_RIs4lEvIywH4qN_F-Hn13Zbsf0hXAZ1ggSQ");'></div>
<div class="absolute top-4 left-4 bg-accent-gold text-white text-[10px] font-black px-2 py-1 rounded-full uppercase tracking-tighter">Rare Find</div>
<button class="absolute bottom-4 right-4 size-10 bg-white text-black rounded-full flex items-center justify-center opacity-0 translate-y-2 group-hover:opacity-100 group-hover:translate-y-0 transition-all shadow-xl">
<span class="material-symbols-outlined">add_shopping_cart</span>
</button>
</div>
<div class="p-4">
<p class="text-[10px] text-accent-gold font-bold uppercase mb-1">Champagne</p>
<h4 class="font-bold text-lg leading-tight mb-2">Vintage Blanc de Noirs</h4>
<div class="flex items-center justify-between">
<span class="text-xl font-black text-primary">$340.00</span>
<div class="flex items-center gap-1">
<span class="material-symbols-outlined text-accent-gold text-xs fill-1">star</span>
<span class="text-xs font-medium">4.9</span>
</div>
</div>
</div>
</div>
</div>
</section>
<!-- Shop by Category -->
<section class="py-12 bg-white/5 rounded-3xl mx-6">
<h2 class="text-2xl font-bold px-8 pb-8 dark:text-white">Shop by Category</h2>
<div class="grid grid-cols-2 md:grid-cols-4 gap-4 px-8">
<a class="group relative aspect-square rounded-xl overflow-hidden border border-white/10" href="#">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-500 group-hover:scale-110" data-alt="Close up of whiskey glass and bottle" style='background-image: linear-gradient(0deg, rgba(0,0,0,0.8) 0%, rgba(0,0,0,0) 60%), url("https://lh3.googleusercontent.com/aida-public/AB6AXuCYEOQ0Q5I4piklcZmk93HjV8wZC-5KhsfPoNR7q1tyWhkdWrMdEiYm9ZVds_S9Pwj4DFEQ9nfWsoEhUsLwn-hDS03oZ2_Jmhqk5ig3VGhsMqZRF_ygl-z-fE1Ak4Y2FsNIgpPo_t_0DJjDS27T488IflGuYS9nCIrIbkvDgtuMcFGPwtjDOQNqxi9UL79tOq_UhIgpz1hFcWlXvz3PkYSYb_aFytP2VNP_1eTdRT-cWxJOwzTJinmVkvzZmV6z8jUMDslWWKhQuaqQ");'></div>
<div class="absolute inset-0 border-2 border-transparent group-hover:border-accent-gold/50 rounded-xl transition-colors"></div>
<div class="absolute bottom-4 left-4">
<p class="text-white text-xl font-black tracking-tight">Whiskey</p>
<div class="h-1 w-0 group-hover:w-full bg-primary transition-all duration-300"></div>
</div>
</a>
<a class="group relative aspect-square rounded-xl overflow-hidden border border-white/10" href="#">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-500 group-hover:scale-110" data-alt="Clear gin bottle with lime and botanicals" style='background-image: linear-gradient(0deg, rgba(0,0,0,0.8) 0%, rgba(0,0,0,0) 60%), url("https://lh3.googleusercontent.com/aida-public/AB6AXuAVoC0ldCwqvQXL23eQD22npPyhpbZpOdbacv6Fd-XFF2WeIGXA3ImaaSs93sxi_q7_u8pI9-v2tGZkZhMoaTGog3Cned31oE4jHKzSMc6lm9RHbQ0m0uWhI5M82xhia5eXqTz5-hnDdK_Kn3sdBWTktyfTy28PGqHwD2h1LO2KbcIYVW11EqMsM0hzpSTjhTUA7imsL2Z7EoZIhgGj6FneiwGtrCvXd0ooUyEJ8Ln0EnUU2eCFlvBtfeNFjuVmqEEmDUKPYiNMTfDp");'></div>
<div class="absolute inset-0 border-2 border-transparent group-hover:border-accent-gold/50 rounded-xl transition-colors"></div>
<div class="absolute bottom-4 left-4">
<p class="text-white text-xl font-black tracking-tight">Gin</p>
<div class="h-1 w-0 group-hover:w-full bg-primary transition-all duration-300"></div>
</div>
</a>
<a class="group relative aspect-square rounded-xl overflow-hidden border border-white/10" href="#">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-500 group-hover:scale-110" data-alt="Red wine being poured into a crystal glass" style='background-image: linear-gradient(0deg, rgba(0,0,0,0.8) 0%, rgba(0,0,0,0) 60%), url("https://lh3.googleusercontent.com/aida-public/AB6AXuDazznFPESaFy8faG_-bceU1m7arupBoivEwlOzDjEYsbLYXt0rE5qEFUuzS-rCGJ7oH5K_6UmwLCwEmH-Oh4SlksDK3iykMFcvY_LlBxvBXEJzKZGrNbCc-MkFHO0D22uiz2paLbU8d9-rkzHoFIWWu69kHaM0uixPno-FRKKgTdhd3ck7oMwrGbnF_V2wMreFosdFod_j8BtVY1FazHz7rDcSzEFHGhXVLXz0IJxfKXHaf5r2_38vExaJygy3C6udpz_3ScOlBko6");'></div>
<div class="absolute inset-0 border-2 border-transparent group-hover:border-accent-gold/50 rounded-xl transition-colors"></div>
<div class="absolute bottom-4 left-4">
<p class="text-white text-xl font-black tracking-tight">Wine</p>
<div class="h-1 w-0 group-hover:w-full bg-primary transition-all duration-300"></div>
</div>
</a>
<a class="group relative aspect-square rounded-xl overflow-hidden border border-white/10" href="#">
<div class="absolute inset-0 bg-cover bg-center transition-transform duration-500 group-hover:scale-110" data-alt="Pouring craft beer into a glass with foam" style='background-image: linear-gradient(0deg, rgba(0,0,0,0.8) 0%, rgba(0,0,0,0) 60%), url("https://lh3.googleusercontent.com/aida-public/AB6AXuDaBjWYHaNyk428Z0NBKt2DjAceOdopiHvIbp1-KR5si21asBDheGnVWnkMUDgo_AY5b9Oxjk8WZNGu9IN5h3jZ69d_wHdEZvMUdVDccanlw8hcFtIRuLMEzMKFlY_SJUQkbML-9rxgF1qfZKPG22cF0uXV1VnXTJuiMOWnor1urW2zmkeOaQvhDg0VuAexSgr9ZRdGRCSSK8zV0b1bnHihxJzh9QqAwEvMqiqdG-ymPEnTd5pC8fxKbrS8ZlKoQ-u9x-pAyW0oWtsR");'></div>
<div class="absolute inset-0 border-2 border-transparent group-hover:border-accent-gold/50 rounded-xl transition-colors"></div>
<div class="absolute bottom-4 left-4">
<p class="text-white text-xl font-black tracking-tight">Craft Beer</p>
<div class="h-1 w-0 group-hover:w-full bg-primary transition-all duration-300"></div>
</div>
</a>
</div>
</section>
<!-- New Arrivals (Minimalist list style) -->
<section class="py-20 px-6">
<h2 class="text-3xl font-bold mb-10 dark:text-white">New Arrivals</h2>
<div class="flex flex-col gap-4">
<div class="group flex items-center justify-between p-4 bg-white/5 rounded-xl hover:bg-white/10 transition-colors border-l-4 border-transparent hover:border-primary">
<div class="flex items-center gap-6">
<div class="size-16 rounded-lg bg-slate-800 bg-cover bg-center" data-alt="Small thumbnail of dark whiskey bottle" style='background-image: url("https://lh3.googleusercontent.com/aida-public/AB6AXuCI7bfxDPMhWT0MgugepCj-3LU-kthvh-L_DSLN1nSCnTXt1TG7LFAO-2_8c_GrpYC5a7ElyQYm2Ly2vW3C4VHQqqvkL4OrrrjXVHS2WJJwpOgm9_c1H16g8JA9zYEG5agoqfpNvLlru4KmqoDdrua0VU2bW-XoELUFMNnIZ4sVSp9Q9yfzEQ1g-az73_5VNWtykddfaklIXauxczLFBvqTSbaqhoeNd4i2zvn94j8pndO49lpBTwwtx-BP2znaVWG2cqPemfwwQuAm");'></div>
<div>
<h5 class="font-bold text-lg">Speyside Rare Malt 1994</h5>
<p class="text-slate-500 text-sm">Distillery Direct • Scotland</p>
</div>
</div>
<div class="flex items-center gap-10">
<span class="font-black text-xl">$525.00</span>
<button class="px-6 py-2 bg-white text-black font-bold rounded-lg text-sm hover:bg-accent-gold hover:text-white transition-colors">Pre-order</button>
</div>
</div>
<div class="group flex items-center justify-between p-4 bg-white/5 rounded-xl hover:bg-white/10 transition-colors border-l-4 border-transparent hover:border-primary">
<div class="flex items-center gap-6">
<div class="size-16 rounded-lg bg-slate-800 bg-cover bg-center" data-alt="Small thumbnail of vintage wine bottle" style='background-image: url("https://lh3.googleusercontent.com/aida-public/AB6AXuCbEIwRil3IroEEnFACd_iGjtvyIoqweMOouPDEUqHe2poccINvsIhDvjKGxZpVf3Ylv8xgZtiY7mg5RORCoPgF3769DWr9Gr86sh4HBu__Ejjht4rDexVTTWyuFu2eGoFoNy4yir_iYRmexeqF9wmWO6jbqM07sLNVoq-ceUJ63TkGtOpxvpr06niQlK30QMJVFiay9z7qSlJlZP3nJFibZzVUuB6wJa62nLzHvH-k-cSQgWkj4Kb5FxkZSeRnNMfYZvoblJv2upaz");'></div>
<div>
<h5 class="font-bold text-lg">Château Margaux 2018</h5>
<p class="text-slate-500 text-sm">Premier Grand Cru • Bordeaux</p>
</div>
</div>
<div class="flex items-center gap-10">
<span class="font-black text-xl">$890.00</span>
<button class="px-6 py-2 bg-white text-black font-bold rounded-lg text-sm hover:bg-accent-gold hover:text-white transition-colors">Add to Cart</button>
</div>
</div>
<div class="group flex items-center justify-between p-4 bg-white/5 rounded-xl hover:bg-white/10 transition-colors border-l-4 border-transparent hover:border-primary">
<div class="flex items-center gap-6">
<div class="size-16 rounded-lg bg-slate-800 bg-cover bg-center" data-alt="Small thumbnail of premium vodka bottle" style='background-image: url("https://lh3.googleusercontent.com/aida-public/AB6AXuBrsPquvsy2evDe2T3ahHdzIIDdLP9B_CltfM48HepF9YLvpmQZOASu_No1rhbI4LIpdeGYugMFX0hsDZ4xPa3u8H_0xPRXuRcepbHXNw2QDOipEm-epdjnm2QaUH-VT80lcxRpqGApb9dWF6W4zRwWVq23iCwzbypyXEcaObq7oDO0taPhSzD9Z3IcthkCXlNtrTiRvC1716OUNI-s7TFs6r1b2oeWSguKNbihlJEmLsgf6-gqNxWRMZ8dAXHFgxrlna7Pdn1-ure2");'></div>
<div>
<h5 class="font-bold text-lg">Crystal Clear Ultra Premium</h5>
<p class="text-slate-500 text-sm">Handcrafted • Poland</p>
</div>
</div>
<div class="flex items-center gap-10">
<span class="font-black text-xl">$45.00</span>
<button class="px-6 py-2 bg-white text-black font-bold rounded-lg text-sm hover:bg-accent-gold hover:text-white transition-colors">Add to Cart</button>
</div>
</div>
</div>
</section>
</main>
<!-- Footer -->
<footer class="bg-black text-white pt-20 pb-10 border-t border-white/10">
<div class="max-w-[1200px] mx-auto px-6">
<div class="grid grid-cols-1 md:grid-cols-4 gap-12 mb-20">
<div class="col-span-1 md:col-span-1">
<div class="flex items-center gap-3 mb-6">
<span class="material-symbols-outlined text-primary text-3xl">liquor</span>
<h1 class="text-xl font-black tracking-tighter uppercase">SpiritLuxury</h1>
</div>
<p class="text-slate-400 text-sm leading-relaxed mb-6">Curating the world's finest spirits for the discerning collector. Established 1998.</p>
<div class="flex gap-4">
<a class="size-10 rounded-full border border-white/20 flex items-center justify-center hover:border-primary transition-colors" href="#">
<span class="material-symbols-outlined text-sm">public</span>
</a>
<a class="size-10 rounded-full border border-white/20 flex items-center justify-center hover:border-primary transition-colors" href="#">
<span class="material-symbols-outlined text-sm">share</span>
</a>
<a class="size-10 rounded-full border border-white/20 flex items-center justify-center hover:border-primary transition-colors" href="#">
<span class="material-symbols-outlined text-sm">chat</span>
</a>
</div>
</div>
<div>
<h6 class="font-bold uppercase text-xs tracking-widest text-accent-gold mb-6">Navigation</h6>
<ul class="flex flex-col gap-4 text-sm text-slate-400">
<li><a class="hover:text-white transition-colors" href="#">Storefront</a></li>
<li><a class="hover:text-white transition-colors" href="#">Rare Finds</a></li>
<li><a class="hover:text-white transition-colors" href="#">Gift Guide</a></li>
<li><a class="hover:text-white transition-colors" href="#">Events</a></li>
</ul>
</div>
<div>
<h6 class="font-bold uppercase text-xs tracking-widest text-accent-gold mb-6">Customer Care</h6>
<ul class="flex flex-col gap-4 text-sm text-slate-400">
<li><a class="hover:text-white transition-colors" href="#">Shipping &amp; Returns</a></li>
<li><a class="hover:text-white transition-colors" href="#">Age Verification</a></li>
<li><a class="hover:text-white transition-colors" href="#">Member Login</a></li>
<li><a class="hover:text-white transition-colors" href="#">Help Center</a></li>
</ul>
</div>
<div>
<h6 class="font-bold uppercase text-xs tracking-widest text-accent-gold mb-6">Join the Connoisseurs</h6>
<p class="text-sm text-slate-400 mb-4">Subscribe for early access to limited releases.</p>
<form class="flex flex-col gap-3">
<input class="bg-white/5 border-white/10 rounded-lg py-3 px-4 focus:ring-primary focus:border-primary text-sm" placeholder="email@address.com" type="email"/>
<button class="w-full py-3 bg-primary text-white font-bold rounded-lg hover:bg-primary/90 transition-colors">Sign Up</button>
</form>
</div>
</div>
<div class="border-t border-white/5 pt-10 flex flex-col md:flex-row items-center justify-between gap-6">
<p class="text-[10px] text-slate-500 max-w-xl text-center md:text-left">
                    ADULT SIGNATURE REQUIRED AT DELIVERY. You must be at least 21 years of age to purchase alcohol. Please drink responsibly. Government Warning: (1) According to the Surgeon General, women should not drink alcoholic beverages during pregnancy because of the risk of birth defects. (2) Consumption of alcoholic beverages impairs your ability to drive a car or operate machinery, and may cause health problems.
                </p>
<p class="text-xs text-slate-400">© 2024 SpiritLuxury International. All rights reserved.</p>
</div>
</div>
</footer>
</body></html>