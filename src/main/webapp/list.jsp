<!DOCTYPE html>

<html class="dark" lang="en"><head>
<meta charset="utf-8"/>
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<title>Premium Spirits - Whiskey Selection</title>
<script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
<link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@300;400;500;600;700;900&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
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
                        "display": ["Work Sans"]
                    },
                    borderRadius: {"DEFAULT": "0.25rem", "lg": "0.5rem", "xl": "0.75rem", "full": "9999px"},
                },
            },
        }
    </script>
<style>
        body { font-family: 'Work Sans', sans-serif; }
        .material-symbols-outlined { font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24; }
    </style>
</head>
<body class="bg-background-light dark:bg-background-dark text-slate-900 dark:text-white transition-colors duration-200">
<!-- Header Navigation -->
<header class="sticky top-0 z-50 w-full border-b border-zinc-200 dark:border-zinc-800 bg-background-light/95 dark:bg-background-dark/95 backdrop-blur">
<div class="max-w-[1440px] mx-auto flex items-center justify-between px-6 py-4">
<div class="flex items-center gap-10">
<div class="flex items-center gap-2 text-primary">
<span class="material-symbols-outlined text-3xl">liquor</span>
<h2 class="text-xl font-black tracking-tighter uppercase italic">Premium Spirits</h2>
</div>
<nav class="hidden md:flex items-center gap-8">
<a class="text-primary text-sm font-semibold border-b-2 border-primary pb-1" href="#">Whiskey</a>
<a class="text-zinc-600 dark:text-zinc-400 hover:text-primary dark:hover:text-primary text-sm font-medium transition-colors" href="#">Gin</a>
<a class="text-zinc-600 dark:text-zinc-400 hover:text-primary dark:hover:text-primary text-sm font-medium transition-colors" href="#">Vodka</a>
<a class="text-zinc-600 dark:text-zinc-400 hover:text-primary dark:hover:text-primary text-sm font-medium transition-colors" href="#">Rum</a>
<a class="text-zinc-600 dark:text-zinc-400 hover:text-primary dark:hover:text-primary text-sm font-medium transition-colors" href="#">Wine</a>
</nav>
</div>
<div class="flex flex-1 justify-end items-center gap-6">
<div class="relative w-full max-w-xs">
<span class="material-symbols-outlined absolute left-3 top-1/2 -translate-y-1/2 text-zinc-400 text-lg">search</span>
<input class="w-full bg-zinc-100 dark:bg-zinc-800 border-none rounded-full pl-10 pr-4 py-2 text-sm focus:ring-2 focus:ring-primary/50" placeholder="Search our collection..." type="text"/>
</div>
<div class="flex gap-4">
<button class="relative p-2 hover:bg-zinc-100 dark:hover:bg-zinc-800 rounded-full transition-colors">
<span class="material-symbols-outlined">shopping_cart</span>
<span class="absolute top-1 right-1 bg-primary text-[10px] text-white font-bold h-4 w-4 flex items-center justify-center rounded-full">3</span>
</button>
<button class="p-2 hover:bg-zinc-100 dark:hover:bg-zinc-800 rounded-full transition-colors">
<span class="material-symbols-outlined">person</span>
</button>
</div>
</div>
</div>
</header>
<main class="max-w-[1440px] mx-auto flex gap-8 px-6 py-8">
<!-- Sidebar Filters -->
<aside class="w-64 shrink-0 hidden lg:flex flex-col gap-8">
<div class="flex items-center justify-between">
<h3 class="text-lg font-bold">Filters</h3>
<button class="text-xs text-primary font-medium hover:underline">Clear all</button>
</div>
<!-- Price Filter Component -->
<div class="space-y-4">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined text-zinc-400 text-xl">payments</span>
<span class="text-sm font-semibold uppercase tracking-wider">Price Range</span>
</div>
<div class="px-2">
<div class="relative h-1 w-full bg-zinc-200 dark:bg-zinc-700 rounded-full">
<div class="absolute h-full left-1/4 right-1/4 bg-primary rounded-full"></div>
<div class="absolute top-1/2 -translate-y-1/2 left-1/4 h-4 w-4 bg-white border-2 border-primary rounded-full cursor-pointer shadow-sm"></div>
<div class="absolute top-1/2 -translate-y-1/2 right-1/4 h-4 w-4 bg-white border-2 border-primary rounded-full cursor-pointer shadow-sm"></div>
</div>
<div class="flex justify-between mt-6 text-xs font-medium text-zinc-500">
<span>$50</span>
<span>$500+</span>
</div>
</div>
</div>
<!-- Alcohol Type Filter -->
<div class="space-y-4">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined text-zinc-400 text-xl">category</span>
<span class="text-sm font-semibold uppercase tracking-wider">Type</span>
</div>
<div class="space-y-3">
<label class="flex items-center gap-3 cursor-pointer group">
<input checked="" class="rounded border-zinc-300 dark:border-zinc-700 text-primary focus:ring-primary bg-transparent" type="checkbox"/>
<span class="text-sm group-hover:text-primary transition-colors">Single Malt</span>
</label>
<label class="flex items-center gap-3 cursor-pointer group">
<input class="rounded border-zinc-300 dark:border-zinc-700 text-primary focus:ring-primary bg-transparent" type="checkbox"/>
<span class="text-sm group-hover:text-primary transition-colors">Bourbon</span>
</label>
<label class="flex items-center gap-3 cursor-pointer group">
<input class="rounded border-zinc-300 dark:border-zinc-700 text-primary focus:ring-primary bg-transparent" type="checkbox"/>
<span class="text-sm group-hover:text-primary transition-colors">Rye Whiskey</span>
</label>
<label class="flex items-center gap-3 cursor-pointer group">
<input class="rounded border-zinc-300 dark:border-zinc-700 text-primary focus:ring-primary bg-transparent" type="checkbox"/>
<span class="text-sm group-hover:text-primary transition-colors">Blended Malt</span>
</label>
</div>
</div>
<!-- Brand Filter -->
<div class="space-y-4">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined text-zinc-400 text-xl">label</span>
<span class="text-sm font-semibold uppercase tracking-wider">Top Brands</span>
</div>
<div class="space-y-3">
<label class="flex items-center gap-3 cursor-pointer group">
<input class="rounded border-zinc-300 dark:border-zinc-700 text-primary focus:ring-primary bg-transparent" type="checkbox"/>
<span class="text-sm group-hover:text-primary transition-colors">The Macallan</span>
</label>
<label class="flex items-center gap-3 cursor-pointer group">
<input class="rounded border-zinc-300 dark:border-zinc-700 text-primary focus:ring-primary bg-transparent" type="checkbox"/>
<span class="text-sm group-hover:text-primary transition-colors">Glenfiddich</span>
</label>
<label class="flex items-center gap-3 cursor-pointer group">
<input class="rounded border-zinc-300 dark:border-zinc-700 text-primary focus:ring-primary bg-transparent" type="checkbox"/>
<span class="text-sm group-hover:text-primary transition-colors">Buffalo Trace</span>
</label>
<label class="flex items-center gap-3 cursor-pointer group">
<input class="rounded border-zinc-300 dark:border-zinc-700 text-primary focus:ring-primary bg-transparent" type="checkbox"/>
<span class="text-sm group-hover:text-primary transition-colors">Lagavulin</span>
</label>
</div>
</div>
<!-- Availability -->
<div class="space-y-4 pt-4 border-t border-zinc-200 dark:border-zinc-800">
<div class="flex items-center justify-between cursor-pointer group">
<div class="flex items-center gap-2">
<span class="material-symbols-outlined text-zinc-400 text-xl">verified</span>
<span class="text-sm font-semibold uppercase tracking-wider">In Stock Only</span>
</div>
<div class="w-10 h-5 bg-primary rounded-full relative">
<div class="absolute right-1 top-1 h-3 w-3 bg-white rounded-full"></div>
</div>
</div>
</div>
</aside>
<!-- Product Listing Area -->
<section class="flex-1">
<!-- Breadcrumbs & Heading -->
<div class="mb-8">
<nav class="flex items-center gap-2 text-sm text-zinc-500 mb-4">
<a class="hover:text-primary" href="#">Home</a>
<span class="material-symbols-outlined text-xs">chevron_right</span>
<a class="hover:text-primary" href="#">Spirits</a>
<span class="material-symbols-outlined text-xs">chevron_right</span>
<span class="text-zinc-900 dark:text-zinc-100 font-medium uppercase tracking-tight">Whiskey</span>
</nav>
<div class="flex flex-col md:flex-row md:items-end justify-between gap-4">
<div>
<h1 class="text-5xl font-black mb-2 tracking-tight">Premium Whiskey</h1>
<p class="text-zinc-500 dark:text-zinc-400 max-w-xl leading-relaxed">
                            Discover our curated collection of fine malts, rare aged barrels, and exceptional blends from the world's most prestigious distilleries.
                        </p>
</div>
<div class="flex items-center gap-4 shrink-0">
<span class="text-sm text-zinc-500 whitespace-nowrap">Showing 24 products</span>
<div class="relative">
<select class="appearance-none bg-zinc-100 dark:bg-zinc-800 border-none rounded-lg pl-4 pr-10 py-2 text-sm font-medium focus:ring-2 focus:ring-primary/50 cursor-pointer">
<option>Sort by: Most Popular</option>
<option>Price: Low to High</option>
<option>Price: High to Low</option>
<option>Customer Rating</option>
</select>
<span class="material-symbols-outlined absolute right-3 top-1/2 -translate-y-1/2 pointer-events-none text-zinc-500">expand_more</span>
</div>
</div>
</div>
</div>
<!-- Product Grid -->
<div class="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-6">
<!-- Product Card 1 -->
<div class="group relative flex flex-col bg-zinc-100 dark:bg-zinc-800/40 rounded-xl overflow-hidden border border-transparent hover:border-primary/30 transition-all duration-300">
<div class="aspect-[4/5] relative overflow-hidden bg-zinc-200 dark:bg-zinc-900 flex items-center justify-center p-8">
<img alt="Luxury whiskey bottle" class="h-full object-contain mix-blend-multiply dark:mix-blend-normal transform group-hover:scale-110 transition-transform duration-500" data-alt="Premium glass bottle of golden single malt whiskey" src="https://lh3.googleusercontent.com/aida-public/AB6AXuBKpDI482vrGjjQGfRFFof8OVr-2fKlSwlSZeypCwCVof9SebmXOux82HL4nO9h-ZwunSwk293QKlDR4sEW-B6rO6TJzoD4Ie0eiN1nELWW03sb2FfJgGhq8c7zNRly4_w_baqw8PFNv6nCS92pKZx2BV68vINJY8LNBAwwGeiiInDBIxLKUxlmNZvdyaJM4O14kOoTdFOHBiaKg6urvRH1K3QEru8jMaA-Q_U9SJh9v2TXknsrKlkIn42WlQANVsdonu5HFvDYx01-"/>
<div class="absolute inset-x-0 bottom-0 p-4 translate-y-full group-hover:translate-y-0 transition-transform duration-300">
<button class="w-full bg-primary text-white font-bold py-3 rounded-lg shadow-xl shadow-primary/20 flex items-center justify-center gap-2 hover:bg-primary/90">
<span class="material-symbols-outlined text-xl">add_shopping_cart</span>
                                QUICK ADD
                            </button>
</div>
<button class="absolute top-4 right-4 h-10 w-10 bg-white/10 backdrop-blur rounded-full flex items-center justify-center hover:bg-white/20 transition-colors">
<span class="material-symbols-outlined text-white">favorite</span>
</button>
</div>
<div class="p-6">
<p class="text-xs font-bold text-primary uppercase tracking-widest mb-1">Speyside, Scotland</p>
<h3 class="text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">The Macallan 18 Year Double Cask</h3>
<div class="flex items-center gap-2 mb-4">
<div class="flex text-amber-400">
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
</div>
<span class="text-xs text-zinc-500">(124 reviews)</span>
</div>
<p class="text-2xl font-black">$349.99</p>
</div>
</div>
<!-- Product Card 2 -->
<div class="group relative flex flex-col bg-zinc-100 dark:bg-zinc-800/40 rounded-xl overflow-hidden border border-transparent hover:border-primary/30 transition-all duration-300">
<div class="aspect-[4/5] relative overflow-hidden bg-zinc-200 dark:bg-zinc-900 flex items-center justify-center p-8">
<img alt="Premium bourbon bottle" class="h-full object-contain mix-blend-multiply dark:mix-blend-normal transform group-hover:scale-110 transition-transform duration-500" data-alt="A bottle of artisanal bourbon with a wooden cork" src="https://lh3.googleusercontent.com/aida-public/AB6AXuCEmiZHKyotbhRvTdngrfTJiwYSRcWqocNzHiSq6mRudlx84lp6Cn0UYwEe5W_6j08dXdf0Mih9WCGTtJu4op5sTcTgyErQapeeE5YoNSEtLdsjIqXrwh662W_Q2Hu44sTLWS37cskEEViwIY9LBoZZUdVfSQgq7arwHCo2xyid5bsvYMFJ9XqrIVotl9854qeQKDuLeRwhLJByc62oiSRtXYZrpBC_kxvt8G4-xqe11EECHIM1dKI0Qpui1tU5vQer5nV633Tr0Nsa"/>
<div class="absolute inset-x-0 bottom-0 p-4 translate-y-full group-hover:translate-y-0 transition-transform duration-300">
<button class="w-full bg-primary text-white font-bold py-3 rounded-lg shadow-xl shadow-primary/20 flex items-center justify-center gap-2 hover:bg-primary/90">
<span class="material-symbols-outlined text-xl">add_shopping_cart</span>
                                QUICK ADD
                            </button>
</div>
<div class="absolute top-4 left-4 bg-primary text-white text-[10px] font-black uppercase px-2 py-1 rounded">Rare Find</div>
<button class="absolute top-4 right-4 h-10 w-10 bg-white/10 backdrop-blur rounded-full flex items-center justify-center hover:bg-white/20 transition-colors">
<span class="material-symbols-outlined text-white">favorite</span>
</button>
</div>
<div class="p-6">
<p class="text-xs font-bold text-primary uppercase tracking-widest mb-1">Kentucky, USA</p>
<h3 class="text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Buffalo Trace Antique Collection</h3>
<div class="flex items-center gap-2 mb-4">
<div class="flex text-amber-400">
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star_half</span>
</div>
<span class="text-xs text-zinc-500">(89 reviews)</span>
</div>
<p class="text-2xl font-black">$189.00</p>
</div>
</div>
<!-- Product Card 3 -->
<div class="group relative flex flex-col bg-zinc-100 dark:bg-zinc-800/40 rounded-xl overflow-hidden border border-transparent hover:border-primary/30 transition-all duration-300">
<div class="aspect-[4/5] relative overflow-hidden bg-zinc-200 dark:bg-zinc-900 flex items-center justify-center p-8">
<img alt="Japanese Whiskey" class="h-full object-contain mix-blend-multiply dark:mix-blend-normal transform group-hover:scale-110 transition-transform duration-500" data-alt="Minimalist bottle of premium Japanese whiskey" src="https://lh3.googleusercontent.com/aida-public/AB6AXuA-UzeH1GYEm-VXBvwMvyso5dShtclOrHi9URE_z4UdDsY_aM5D94xM_4rx401Vp3BCl2YkvD4t9DxjbK1-8YMwgBceN_PbWrjc5c5nfl4J9DVkeuDP3bVHrw5tz2Ip3P5S-V5iReJzG9H-kzONaj81ET3K8UDynfQg4m54xP6i-F1pFfhZqgtgowz-R32eID4FLkcfoaW-57dQ4DRnRA2FU0j9HYq4hYbEmuCFwHdSk_Hx2YF7iLWDEzhNuRhpK27RbH1sp4XpG2F2"/>
<div class="absolute inset-x-0 bottom-0 p-4 translate-y-full group-hover:translate-y-0 transition-transform duration-300">
<button class="w-full bg-primary text-white font-bold py-3 rounded-lg shadow-xl shadow-primary/20 flex items-center justify-center gap-2 hover:bg-primary/90">
<span class="material-symbols-outlined text-xl">add_shopping_cart</span>
                                QUICK ADD
                            </button>
</div>
<button class="absolute top-4 right-4 h-10 w-10 bg-white/10 backdrop-blur rounded-full flex items-center justify-center hover:bg-white/20 transition-colors">
<span class="material-symbols-outlined text-white">favorite</span>
</button>
</div>
<div class="p-6">
<p class="text-xs font-bold text-primary uppercase tracking-widest mb-1">Yamanashi, Japan</p>
<h3 class="text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Hibiki Japanese Harmony</h3>
<div class="flex items-center gap-2 mb-4">
<div class="flex text-amber-400">
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
</div>
<span class="text-xs text-zinc-500">(210 reviews)</span>
</div>
<p class="text-2xl font-black">$125.00</p>
</div>
</div>
<!-- Product Card 4 -->
<div class="group relative flex flex-col bg-zinc-100 dark:bg-zinc-800/40 rounded-xl overflow-hidden border border-transparent hover:border-primary/30 transition-all duration-300">
<div class="aspect-[4/5] relative overflow-hidden bg-zinc-200 dark:bg-zinc-900 flex items-center justify-center p-8">
<img alt="Islay Scotch Whiskey" class="h-full object-contain mix-blend-multiply dark:mix-blend-normal transform group-hover:scale-110 transition-transform duration-500" data-alt="Smoky dark bottle of Islay scotch whiskey" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDBA1QtPhtwLTc3ORphLGtwgYE-blDN0YNHbQH1Mr-rt6-6Ig5zfUW8kozsrv_Vw9tPwIQfZIm3_zYAS1U92IYpiqs44K1j40x1XGcyunHPAB9HrOKui-Fl-QAvxUuvbTSq9FLPhbcgxTSYKfh2T3rGySi737V1MlrpqAU45qdAfJ-rk0Uh16yPh5ner9ToXkNn2AaagmYU0K9ST0_O4E3r-H5gkxq4XoVBq4-wtaSHxj-foeLnIRX1q7C0XBkO-8FDxOBle7_kCMmG"/>
<div class="absolute inset-x-0 bottom-0 p-4 translate-y-full group-hover:translate-y-0 transition-transform duration-300">
<button class="w-full bg-primary text-white font-bold py-3 rounded-lg shadow-xl shadow-primary/20 flex items-center justify-center gap-2 hover:bg-primary/90">
<span class="material-symbols-outlined text-xl">add_shopping_cart</span>
                                QUICK ADD
                            </button>
</div>
<button class="absolute top-4 right-4 h-10 w-10 bg-white/10 backdrop-blur rounded-full flex items-center justify-center hover:bg-white/20 transition-colors">
<span class="material-symbols-outlined text-white">favorite</span>
</button>
</div>
<div class="p-6">
<p class="text-xs font-bold text-primary uppercase tracking-widest mb-1">Islay, Scotland</p>
<h3 class="text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Lagavulin 16 Year Single Malt</h3>
<div class="flex items-center gap-2 mb-4">
<div class="flex text-amber-400">
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star_half</span>
</div>
<span class="text-xs text-zinc-500">(345 reviews)</span>
</div>
<p class="text-2xl font-black">$105.99</p>
</div>
</div>
<!-- Product Card 5 -->
<div class="group relative flex flex-col bg-zinc-100 dark:bg-zinc-800/40 rounded-xl overflow-hidden border border-transparent hover:border-primary/30 transition-all duration-300">
<div class="aspect-[4/5] relative overflow-hidden bg-zinc-200 dark:bg-zinc-900 flex items-center justify-center p-8">
<img alt="Premium Blended Scotch" class="h-full object-contain mix-blend-multiply dark:mix-blend-normal transform group-hover:scale-110 transition-transform duration-500" data-alt="Classic tall bottle of blended scotch whiskey" src="https://lh3.googleusercontent.com/aida-public/AB6AXuCsxTT4M9MqzC-tF7SRjt3flKdLsH4na_nT-Td2RymvoJjWKXCO5M-DFknVHjp_1_qZGS8QwIg6E4xQEQmU1SO6nsgsbC8g9FTKjlPjFwg_O9jr-ipNP9DPsr0B4bhc0vzgJjoWs6YK0OdP4-NzcevrvC5ANMTgnYbRHrGRBsPxO_HUqfhvZ_kFuMH0wjkEHLPI__-4TpyK6hbIljIQmSkLNbWtPk_JqdFt9zf-bs2hui9SYyBY7_0cruclFOhBNccEStqK-RPBpifx"/>
<div class="absolute inset-x-0 bottom-0 p-4 translate-y-full group-hover:translate-y-0 transition-transform duration-300">
<button class="w-full bg-primary text-white font-bold py-3 rounded-lg shadow-xl shadow-primary/20 flex items-center justify-center gap-2 hover:bg-primary/90">
<span class="material-symbols-outlined text-xl">add_shopping_cart</span>
                                QUICK ADD
                            </button>
</div>
<button class="absolute top-4 right-4 h-10 w-10 bg-white/10 backdrop-blur rounded-full flex items-center justify-center hover:bg-white/20 transition-colors">
<span class="material-symbols-outlined text-white">favorite</span>
</button>
</div>
<div class="p-6">
<p class="text-xs font-bold text-primary uppercase tracking-widest mb-1">Highlands, Scotland</p>
<h3 class="text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Johnnie Walker Blue Label</h3>
<div class="flex items-center gap-2 mb-4">
<div class="flex text-amber-400">
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
</div>
<span class="text-xs text-zinc-500">(512 reviews)</span>
</div>
<p class="text-2xl font-black">$229.00</p>
</div>
</div>
<!-- Product Card 6 -->
<div class="group relative flex flex-col bg-zinc-100 dark:bg-zinc-800/40 rounded-xl overflow-hidden border border-transparent hover:border-primary/30 transition-all duration-300">
<div class="aspect-[4/5] relative overflow-hidden bg-zinc-200 dark:bg-zinc-900 flex items-center justify-center p-8">
<img alt="Irish Whiskey" class="h-full object-contain mix-blend-multiply dark:mix-blend-normal transform group-hover:scale-110 transition-transform duration-500" data-alt="Traditional rounded bottle of triple distilled Irish whiskey" src="https://lh3.googleusercontent.com/aida-public/AB6AXuC0oVhBjhlEs2ERzSyZeKkw5nTR--yXkGpxj72T7RanxtSFOcecbaKGUWgDcXAM3QhGq0gSHNZ_ZqF9zEMTXmBlYTszYU_XPDKxbnL56MC4hQDxvvmMkhb8wjXCMfjbFeIvaId3iLhzr9hQuQ6qin55B8hKb8QkyVGJZRFjfRdGVUJvzyPmUa_hHMgVYjhu78JV7LnGrELKgEx48C5A2E0buFi1C5Urvw7H1M_6YBGKcRjSDES8PacQ6JUN_XcvFJUNaG-euoenZ4Wb"/>
<div class="absolute inset-x-0 bottom-0 p-4 translate-y-full group-hover:translate-y-0 transition-transform duration-300">
<button class="w-full bg-primary text-white font-bold py-3 rounded-lg shadow-xl shadow-primary/20 flex items-center justify-center gap-2 hover:bg-primary/90">
<span class="material-symbols-outlined text-xl">add_shopping_cart</span>
                                QUICK ADD
                            </button>
</div>
<button class="absolute top-4 right-4 h-10 w-10 bg-white/10 backdrop-blur rounded-full flex items-center justify-center hover:bg-white/20 transition-colors">
<span class="material-symbols-outlined text-white">favorite</span>
</button>
</div>
<div class="p-6">
<p class="text-xs font-bold text-primary uppercase tracking-widest mb-1">Dublin, Ireland</p>
<h3 class="text-lg font-bold leading-tight mb-2 group-hover:text-primary transition-colors">Redbreast 15 Year Single Pot Still</h3>
<div class="flex items-center gap-2 mb-4">
<div class="flex text-amber-400">
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star</span>
<span class="material-symbols-outlined text-sm">star_half</span>
</div>
<span class="text-xs text-zinc-500">(167 reviews)</span>
</div>
<p class="text-2xl font-black">$119.50</p>
</div>
</div>
</div>
<!-- Pagination -->
<div class="mt-16 flex flex-col items-center gap-6">
<button class="px-12 py-4 border-2 border-primary text-primary font-black uppercase tracking-[0.2em] rounded-lg hover:bg-primary hover:text-white transition-all">
                    Load More Selections
                </button>
<div class="flex items-center gap-4">
<div class="h-1.5 w-16 bg-primary rounded-full"></div>
<div class="h-1.5 w-4 bg-zinc-300 dark:bg-zinc-700 rounded-full"></div>
<div class="h-1.5 w-4 bg-zinc-300 dark:bg-zinc-700 rounded-full"></div>
</div>
</div>
</section>
</main>
<!-- Footer -->
<footer class="bg-zinc-100 dark:bg-background-dark border-t border-zinc-200 dark:border-zinc-800 mt-20">
<div class="max-w-[1440px] mx-auto px-6 py-12">
<div class="grid grid-cols-1 md:grid-cols-4 gap-12">
<div class="space-y-4">
<div class="flex items-center gap-2 text-primary">
<span class="material-symbols-outlined text-2xl">liquor</span>
<h2 class="text-lg font-black tracking-tighter uppercase italic">Premium Spirits</h2>
</div>
<p class="text-sm text-zinc-500 leading-relaxed">Defining luxury through curated excellence since 1994. The world's finest distillery archive, delivered to your cellar.</p>
</div>
<div>
<h4 class="font-bold mb-4 uppercase tracking-wider text-sm">Collection</h4>
<ul class="space-y-2 text-sm text-zinc-500">
<li><a class="hover:text-primary transition-colors" href="#">Rare Malts</a></li>
<li><a class="hover:text-primary transition-colors" href="#">Limited Releases</a></li>
<li><a class="hover:text-primary transition-colors" href="#">Award Winners</a></li>
<li><a class="hover:text-primary transition-colors" href="#">New Arrivals</a></li>
</ul>
</div>
<div>
<h4 class="font-bold mb-4 uppercase tracking-wider text-sm">Assistance</h4>
<ul class="space-y-2 text-sm text-zinc-500">
<li><a class="hover:text-primary transition-colors" href="#">Shipping Information</a></li>
<li><a class="hover:text-primary transition-colors" href="#">Returns &amp; Exchanges</a></li>
<li><a class="hover:text-primary transition-colors" href="#">Tasting Events</a></li>
<li><a class="hover:text-primary transition-colors" href="#">Contact Expert</a></li>
</ul>
</div>
<div>
<h4 class="font-bold mb-4 uppercase tracking-wider text-sm">Join the Club</h4>
<p class="text-sm text-zinc-500 mb-4">Access exclusive allocations and private barrel offerings.</p>
<div class="flex gap-2">
<input class="flex-1 bg-white dark:bg-zinc-800 border-none rounded-lg text-sm px-4" placeholder="Email address" type="email"/>
<button class="bg-primary text-white p-2 rounded-lg"><span class="material-symbols-outlined">send</span></button>
</div>
</div>
</div>
<div class="mt-12 pt-8 border-t border-zinc-200 dark:border-zinc-800 flex justify-between items-center text-xs text-zinc-500">
<p>© 2024 Premium Spirits E-Commerce. Please drink responsibly.</p>
<div class="flex gap-6">
<a class="hover:text-white" href="#">Privacy Policy</a>
<a class="hover:text-white" href="#">Terms of Service</a>
</div>
</div>
</div>
</footer>
</body></html>