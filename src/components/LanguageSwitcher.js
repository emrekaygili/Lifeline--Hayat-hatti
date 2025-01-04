import { useTranslation } from 'react-i18next';

function LanguageSwitcher() {
  const { i18n } = useTranslation();

  return (
    <div className="language-switcher">
      <button onClick={() => i18n.changeLanguage('es')}>Español</button>
      <button onClick={() => i18n.changeLanguage('de')}>Deutsch</button>
    </div>
  );
} 