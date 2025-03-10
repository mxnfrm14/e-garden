<template>
    <div class="content-container">
        <div v-if="currentView === 'arrosage'" class="view-content">
            <h3>Gestion de l'Arrosage des Semis</h3>
            <div class="stats-container">
                <div class="stat-card">
                    <h4>Humidité actuelle</h4>
                    <div class="stat-value">65%</div>
                    <div class="stat-chart">
                        <div class="progress-bar">
                            <div class="progress" :style="{ width: '65%' }"></div>
                        </div>
                    </div>
                </div>
                <div class="stat-card">
                    <h4>Dernier arrosage</h4>
                    <div class="stat-value">Il y a 2 heures</div>
                    <div class="last-watered-info">10:15 - 250ml</div>
                </div>
            </div>
            <div class="schedule-container">
                <h4>Planning d'arrosage</h4>
                <ul class="schedule-list">
                    <li class="schedule-item">
                        <div class="schedule-time">08:00</div>
                        <div class="schedule-action">Arrosage automatique - 300ml</div>
                    </li>
                    <li class="schedule-item">
                        <div class="schedule-time">16:00</div>
                        <div class="schedule-action">Arrosage automatique - 300ml</div>
                    </li>
                </ul>
            </div>
        </div>

        <div v-else-if="currentView === 'temperature'" class="view-content">
            <h3>Gestion de la Température</h3>
            <div class="stats-container">
                <div class="stat-card">
                    <h4>Température actuelle</h4>
                    <div class="stat-value">24°C</div>
                    <div class="temp-range">
                        <span>Min: 18°C</span>
                        <span>Max: 28°C</span>
                    </div>
                </div>
                <div class="stat-card">
                    <h4>Humidité relative</h4>
                    <div class="stat-value">55%</div>
                    <div class="stat-chart">
                        <div class="progress-bar">
                            <div class="progress" :style="{ width: '55%' }"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="temperature-chart">
                <h4>Variations sur 24h</h4>
                <div class="chart-placeholder">
                    Graphique des variations de température
                </div>
            </div>
        </div>

        <div v-else-if="currentView === 'plantations'" class="view-content">
            <h3>Gestion des Plantations</h3>
            <div class="plants-grid">
                <div class="plant-card">
                    <div class="plant-header">Tomates</div>
                    <div class="plant-info">
                        <p>Semis le: 15 février</p>
                        <p>Jours restants: 12</p>
                        <div class="growth-indicator">
                            <div class="growth-bar">
                                <div class="growth-progress" :style="{ width: '65%' }"></div>
                            </div>
                            <span>65%</span>
                        </div>
                    </div>
                </div>
                <div class="plant-card">
                    <div class="plant-header">Basilic</div>
                    <div class="plant-info">
                        <p>Semis le: 20 février</p>
                        <p>Jours restants: 8</p>
                        <div class="growth-indicator">
                            <div class="growth-bar">
                                <div class="growth-progress" :style="{ width: '80%' }"></div>
                            </div>
                            <span>80%</span>
                        </div>
                    </div>
                </div>
                <div class="plant-card">
                    <div class="plant-header">Laitue</div>
                    <div class="plant-info">
                        <p>Semis le: 10 février</p>
                        <p>Jours restants: 5</p>
                        <div class="growth-indicator">
                            <div class="growth-bar">
                                <div class="growth-progress" :style="{ width: '90%' }"></div>
                            </div>
                            <span>90%</span>
                        </div>
                    </div>
                </div>
            </div>
            <button class="add-plant-btn">+ Ajouter une plantation</button>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';

// Default view is arrosage
const currentView = ref('arrosage');

// Export the method to change views
defineExpose({
    setView: (view) => {
        currentView.value = view;
    }
});
</script>

<style scoped>
.content-container {
    background-color: white;
    border-radius: 1rem;
    padding: 1.5rem;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
    margin-top: 1rem;
    min-height: 400px;
}

h3 {
    font-family: 'Aeonik-Medium', sans-serif;
    color: #333;
    margin-bottom: 1.5rem;
    font-size: 1.2rem;
}

h4 {
    font-family: 'Aeonik-Medium', sans-serif;
    color: #555;
    margin-bottom: 0.5rem;
    font-size: 1rem;
}

.stats-container {
    display: flex;
    gap: 1.5rem;
    margin-bottom: 2rem;
}

.stat-card {
    background-color: #f9f9f9;
    border-radius: 0.8rem;
    padding: 1rem;
    flex: 1;
}

.stat-value {
    font-size: 1.8rem;
    font-weight: bold;
    color: #333;
    margin: 0.5rem 0;
}

.progress-bar {
    width: 100%;
    height: 0.6rem;
    background-color: #e0e0e0;
    border-radius: 0.3rem;
    overflow: hidden;
    margin-top: 0.5rem;
}

.progress {
    height: 100%;
    background-color: #95bd75;
    border-radius: 0.3rem;
}

.last-watered-info {
    color: #666;
    font-size: 0.9rem;
}

.schedule-container {
    background-color: #f9f9f9;
    border-radius: 0.8rem;
    padding: 1rem;
}

.schedule-list {
    list-style-type: none;
    padding: 0;
}

.schedule-item {
    display: flex;
    padding: 0.8rem 0;
    border-bottom: 1px solid #eee;
}

.schedule-time {
    font-weight: bold;
    width: 80px;
}

.schedule-action {
    flex: 1;
}

.temp-range {
    display: flex;
    justify-content: space-between;
    color: #666;
    font-size: 0.9rem;
    margin-top: 0.5rem;
}

.temperature-chart {
    background-color: #f9f9f9;
    border-radius: 0.8rem;
    padding: 1rem;
    margin-top: 1rem;
}

.chart-placeholder {
    height: 150px;
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px dashed #ccc;
    border-radius: 0.5rem;
    color: #888;
    margin-top: 1rem;
}

.plants-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
    gap: 1rem;
    margin-bottom: 1.5rem;
}

.plant-card {
    background-color: #f9f9f9;
    border-radius: 0.8rem;
    overflow: hidden;
}

.plant-header {
    background-color: #95bd75;
    color: white;
    font-weight: bold;
    padding: 0.8rem 1rem;
}

.plant-info {
    padding: 1rem;
}

.plant-info p {
    margin: 0.3rem 0;
    color: #444;
}

.growth-indicator {
    margin-top: 0.8rem;
    display: flex;
    align-items: center;
    gap: 0.5rem;
}

.growth-bar {
    flex: 1;
    height: 0.5rem;
    background-color: #e0e0e0;
    border-radius: 0.25rem;
    overflow: hidden;
}

.growth-progress {
    height: 100%;
    background-color: #95bd75;
}

.add-plant-btn {
    background-color: #95bd75;
    color: white;
    border: none;
    border-radius: 0.5rem;
    padding: 0.8rem 1.2rem;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.2s;
}

.add-plant-btn:hover {
    background-color: #86aa69;
}

@media (max-width: 768px) {
    .stats-container {
        flex-direction: column;
    }
    
    .plants-grid {
        grid-template-columns: 1fr;
    }
}
</style>