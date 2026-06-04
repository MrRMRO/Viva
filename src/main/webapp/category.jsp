<!DOCTYPE html>

<html class="dark" lang="en"><head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <title>Admin Add Category | Liquor Admin</title>
    <script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
    <link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@300;400;500;600;700;900&amp;display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght@100..700,0..1&amp;display=swap" rel="stylesheet"/>
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
                        "surface-dark": "#2d1618",
                        "border-dark": "#543b3d",
                        "muted-dark": "#b99d9f",
                    },
                    fontFamily: {
                        "display": ["Work Sans", "sans-serif"]
                    },
                    borderRadius: {
                        "DEFAULT": "0.25rem",
                        "lg": "0.5rem",
                        "xl": "0.75rem",
                        "full": "9999px"
                    },
                },
            },
        }
    </script>
    <style>
        body {
            font-family: 'Work Sans', sans-serif;
        }
        .material-symbols-outlined {
            font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24;
        }
    </style>
</head>
<body class="bg-background-light dark:bg-background-dark min-h-screen text-slate-900 dark:text-white">
<div class="relative flex h-auto min-h-screen w-full flex-col group/design-root overflow-x-hidden">
    <div class="layout-container flex h-full grow flex-col">
        <!-- Top Navigation Bar -->
        <header class="flex items-center justify-between whitespace-nowrap border-b border-solid border-slate-200 dark:border-border-dark px-10 py-3 bg-white dark:bg-background-dark sticky top-0 z-50">
            <div class="flex items-center gap-8">
                <div class="flex items-center gap-4 text-primary">
                    <div class="size-6">
                        <span class="material-symbols-outlined text-3xl">liquor</span>
                    </div>
                    <h2 class="text-slate-900 dark:text-white text-lg font-bold leading-tight tracking-[-0.015em] font-display">Liquor Admin</h2>
                </div>
                <nav class="hidden md:flex items-center gap-9">
                    <a class="text-slate-600 dark:text-muted-dark hover:text-primary dark:hover:text-white text-sm font-medium leading-normal transition-colors" href="#">Dashboard</a>
                    <a class="text-slate-600 dark:text-muted-dark hover:text-primary dark:hover:text-white text-sm font-medium leading-normal transition-colors" href="#">Inventory</a>
                    <a class="text-primary dark:text-white text-sm font-medium leading-normal transition-colors border-b-2 border-primary" href="#">Categories</a>
                    <a class="text-slate-600 dark:text-muted-dark hover:text-primary dark:hover:text-white text-sm font-medium leading-normal transition-colors" href="#">Orders</a>
                    <a class="text-slate-600 dark:text-muted-dark hover:text-primary dark:hover:text-white text-sm font-medium leading-normal transition-colors" href="#">Settings</a>
                </nav>
            </div>
            <div class="flex flex-1 justify-end gap-6 items-center">
                <label class="flex flex-col min-w-40 !h-10 max-w-64">
                    <div class="flex w-full flex-1 items-stretch rounded-lg h-full">
                        <div class="text-slate-400 dark:text-muted-dark flex border-none bg-slate-100 dark:bg-surface-dark items-center justify-center pl-4 rounded-l-lg" data-icon="search">
                            <span class="material-symbols-outlined">search</span>
                        </div>
                        <input class="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-lg text-slate-900 dark:text-white focus:outline-0 focus:ring-0 border-none bg-slate-100 dark:bg-surface-dark focus:border-none h-full placeholder:text-slate-400 dark:placeholder:text-muted-dark px-4 rounded-l-none border-l-0 pl-2 text-base font-normal leading-normal" placeholder="Search orders..." value=""/>
                    </div>
                </label>
                <div class="flex items-center gap-3">
                    <span class="material-symbols-outlined text-slate-500 dark:text-muted-dark cursor-pointer hover:text-primary">notifications</span>
                    <div class="bg-center bg-no-repeat aspect-square bg-cover rounded-full size-10 border-2 border-primary/20" data-alt="Admin user profile picture avatar" style='background-image: url("https://lh3.googleusercontent.com/aida-public/AB6AXuB8wOoLgi4dY5vbEOOvhzml0rYhCS6e-j_Y-Euk2qecojvYYYnMX4OAfh1dY-JvxpnpFKXBPTo3WIIZkKaCpQO02vqmg3iG_7pzuRHiSlI4LKtA0uzSvIGSITF24NMpVNSjfNpTtX5Rh1qirqf1TPLFQA7vY9LUP4h83D4wZIuL18jQ1wkG2HIc4yJWk-YOzz-aBzEiOusb38sP9yoGg3CDjloME2cPhKJJNMAprreY3m83xfeYXA8KopnS9DpTFH6JafYI01OPBVe9");'></div>
                </div>
            </div>
        </header>
        <main class="flex flex-1 justify-center py-8">
            <div class="layout-content-container flex flex-col w-full max-w-[960px] px-6">
                <!-- Breadcrumbs -->
                <nav class="flex flex-wrap gap-2 py-2 mb-4">
                    <a class="text-slate-500 dark:text-muted-dark text-sm font-medium leading-normal hover:text-primary" href="#">Dashboard</a>
                    <span class="text-slate-400 dark:text-muted-dark text-sm font-medium leading-normal">/</span>
                    <a class="text-slate-500 dark:text-muted-dark text-sm font-medium leading-normal hover:text-primary" href="#">Categories</a>
                    <span class="text-slate-400 dark:text-muted-dark text-sm font-medium leading-normal">/</span>
                    <span class="text-slate-900 dark:text-white text-sm font-medium leading-normal">Add New</span>
                </nav>
                <!-- Page Heading -->
                <div class="flex flex-wrap justify-between items-end gap-3 mb-8">
                    <div class="flex flex-col gap-1">
                        <h1 class="text-slate-900 dark:text-white text-4xl font-black leading-tight tracking-[-0.033em] font-display">Add New Category</h1>
                        <p class="text-slate-500 dark:text-muted-dark text-base font-normal leading-normal">Organize your premium spirits collection with a new classification.</p>
                    </div>
                </div>
                <!-- Form Card -->
                <div class="bg-white dark:bg-surface-dark rounded-xl shadow-xl border border-slate-200 dark:border-border-dark overflow-hidden">
                    <form class="p-8 space-y-8">
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-8">
                            <!-- Category Name -->
                            <div class="flex flex-col gap-2">
                                <label class="text-slate-900 dark:text-white text-base font-semibold leading-normal">Category Name</label>
                                <input class="form-input w-full rounded-lg text-slate-900 dark:text-white focus:ring-2 focus:ring-primary/50 border border-slate-300 dark:border-border-dark bg-slate-50 dark:bg-[#181112] h-14 placeholder:text-slate-400 dark:placeholder:text-muted-dark p-4 text-base transition-all" placeholder="e.g., Single Malt Scotch" type="text"/>
                            </div>
                            <!-- URL Slug -->
                            <div class="flex flex-col gap-2">
                                <label class="text-slate-900 dark:text-white text-base font-semibold leading-normal">URL Slug</label>
                                <div class="relative">
                                    <input class="form-input w-full rounded-lg text-slate-900 dark:text-white focus:ring-2 focus:ring-primary/50 border border-slate-300 dark:border-border-dark bg-slate-50 dark:bg-[#181112] h-14 placeholder:text-slate-400 dark:placeholder:text-muted-dark p-4 text-base transition-all" placeholder="single-malt-scotch" type="text"/>
                                    <span class="material-symbols-outlined absolute right-4 top-4 text-slate-400 dark:text-muted-dark text-sm">link</span>
                                </div>
                            </div>
                        </div>
                        <!-- Parent Category -->
                        <div class="flex flex-col gap-2">
                            <label class="text-slate-900 dark:text-white text-base font-semibold leading-normal">Parent Category</label>
                            <select class="form-select w-full rounded-lg text-slate-900 dark:text-white focus:ring-2 focus:ring-primary/50 border border-slate-300 dark:border-border-dark bg-slate-50 dark:bg-[#181112] h-14 p-4 text-base transition-all appearance-none">
                                <option value="none">None (Top Level)</option>
                                <option value="whisky">Whisky</option>
                                <option value="gin">Gin</option>
                                <option value="vodka">Vodka</option>
                                <option value="rum">Rum</option>
                                <option value="tequila">Tequila</option>
                            </select>
                        </div>
                        <!-- Description -->
                        <div class="flex flex-col gap-2">
                            <label class="text-slate-900 dark:text-white text-base font-semibold leading-normal">Description</label>
                            <textarea class="form-textarea w-full rounded-lg text-slate-900 dark:text-white focus:ring-2 focus:ring-primary/50 border border-slate-300 dark:border-border-dark bg-slate-50 dark:bg-[#181112] placeholder:text-slate-400 dark:placeholder:text-muted-dark p-4 text-base transition-all" placeholder="Describe this category for your customers and SEO..." rows="4"></textarea>
                        </div>
                        <!-- Image Upload Zone -->
                        <div class="flex flex-col gap-2">
                            <label class="text-slate-900 dark:text-white text-base font-semibold leading-normal">Category Thumbnail</label>
                            <div class="border-2 border-dashed border-slate-300 dark:border-border-dark rounded-xl p-10 flex flex-col items-center justify-center bg-slate-50 dark:bg-[#181112] hover:bg-slate-100 dark:hover:bg-primary/5 transition-colors cursor-pointer group">
                                <div class="bg-primary/10 p-4 rounded-full mb-4 group-hover:scale-110 transition-transform">
                                    <span class="material-symbols-outlined text-primary text-4xl">cloud_upload</span>
                                </div>
                                <p class="text-slate-900 dark:text-white text-lg font-medium">Click to upload or drag and drop</p>
                                <p class="text-slate-500 dark:text-muted-dark text-sm">PNG, JPG or WebP (Recommended 500x500px)</p>
                            </div>
                        </div>
                        <!-- Actions -->
                        <div class="flex items-center justify-end gap-4 pt-6 border-t border-slate-200 dark:border-border-dark">
                            <button class="px-8 h-12 rounded-lg text-slate-600 dark:text-muted-dark font-semibold hover:bg-slate-100 dark:hover:bg-white/5 transition-colors" type="button">
                                Cancel
                            </button>
                            <button class="px-10 h-12 bg-primary rounded-lg text-white font-bold shadow-lg shadow-primary/20 hover:bg-primary/90 transition-all active:scale-95 flex items-center gap-2" type="submit">
                                <span class="material-symbols-outlined text-xl">save</span>
                                Save Category
                            </button>
                        </div>
                    </form>
                </div>
                <!-- Additional Tips Card -->
                <div class="mt-8 grid grid-cols-1 md:grid-cols-3 gap-6">
                    <div class="flex gap-4 p-4 rounded-lg bg-blue-50 dark:bg-blue-900/10 border border-blue-100 dark:border-blue-800/30">
                        <span class="material-symbols-outlined text-blue-500">info</span>
                        <div>
                            <h4 class="text-blue-900 dark:text-blue-300 font-bold text-sm">SEO Optimized</h4>
                            <p class="text-blue-700 dark:text-blue-400/80 text-xs">Slugs help your categories rank higher in search results.</p>
                        </div>
                    </div>
                    <div class="flex gap-4 p-4 rounded-lg bg-amber-50 dark:bg-amber-900/10 border border-amber-100 dark:border-amber-800/30">
                        <span class="material-symbols-outlined text-amber-500">image</span>
                        <div>
                            <h4 class="text-amber-900 dark:text-amber-300 font-bold text-sm">Visual Brand</h4>
                            <p class="text-amber-700 dark:text-amber-400/80 text-xs">High-quality images increase category click-through rates by 40%.</p>
                        </div>
                    </div>
                    <div class="flex gap-4 p-4 rounded-lg bg-emerald-50 dark:bg-emerald-900/10 border border-emerald-100 dark:border-emerald-800/30">
                        <span class="material-symbols-outlined text-emerald-500">account_tree</span>
                        <div>
                            <h4 class="text-emerald-900 dark:text-emerald-300 font-bold text-sm">Hierarchy</h4>
                            <p class="text-emerald-700 dark:text-emerald-400/80 text-xs">Use parent categories to create intuitive navigation for users.</p>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!-- Footer Spacer -->
        <footer class="py-10 text-center text-slate-400 dark:text-muted-dark text-sm">
            © 2024 Liquor Admin Panel • Premium E-commerce Solutions
        </footer>
    </div>
</div>
</body></html>