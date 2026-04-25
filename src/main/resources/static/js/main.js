/* Vica Hydrate - Main JS */

// Navbar scroll effect
(function () {
  const nav = document.getElementById('mainNav');
  if (!nav) return;
  const onScroll = () => {
    if (window.scrollY > 40) {
      nav.classList.add('scrolled');
    } else {
      nav.classList.remove('scrolled');
    }
  };
  window.addEventListener('scroll', onScroll, { passive: true });
  onScroll();
})();

// Simple AOS-like scroll reveal
(function () {
  const els = document.querySelectorAll('[data-aos]');
  if (!els.length) return;

  const delays = {};
  els.forEach(el => {
    const delay = parseInt(el.getAttribute('data-aos-delay') || '0', 10);
    delays.set ? delays.set(el, delay) : (el._aosDelay = delay);
  });

  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        const el = entry.target;
        const delay = parseInt(el.getAttribute('data-aos-delay') || '0', 10);
        setTimeout(() => {
          el.classList.add('aos-animate');
        }, delay);
        observer.unobserve(el);
      }
    });
  }, { threshold: 0.12, rootMargin: '0px 0px -48px 0px' });

  els.forEach(el => observer.observe(el));
})();

// Active nav link highlighting
(function () {
  const path = window.location.pathname;
  document.querySelectorAll('#mainNav .nav-link').forEach(link => {
    const href = link.getAttribute('href');
    if (href === path || (href !== '/' && path.startsWith(href))) {
      link.classList.add('active');
    }
  });
})();

// Smooth scroll for anchor links
document.querySelectorAll('a[href^="#"]').forEach(a => {
  a.addEventListener('click', function (e) {
    const target = document.querySelector(this.getAttribute('href'));
    if (target) {
      e.preventDefault();
      target.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
  });
});
